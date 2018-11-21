/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.TxtAccess;
import java.time.LocalDate;

/**
 *
 * @author Malte
 */
public class Payment {
    private int years; // Years Paid since clubstart.
    private String ID; // ID of the Member.
    private int yearsNotPaid; // Years left to pay.
    private int amountOwed; // Amount owed.
    private Member member; // Member whose payment this is.
    private String name; // name of the Member.
    private TxtAccess txtaccess = new TxtAccess();
    
    public Payment(String ID) {
        this.ID = ID;
        setMember();
        setName();
        setYears();
        setYearsNotPaid();
        setAmountOwed();
    }

    @Override
    public String toString() {
        return "Navn: " + name + 
                " År: " + yearsNotPaid + 
                " At Betale: " + amountOwed + 
                "\n";
    }

    public int getYears() {
        return years;
    }

    public String getName(){
        return this.name;
    }
    
    private void setAmountOwed(){
        Controller cont =  new Controller();
        this.amountOwed = cont.getAmount(this.yearsNotPaid, this.member);
    }

    public int getAmountOwed() {
        return amountOwed;
    }
    
    private void setYears() {
        this.years = txtaccess.findPayment(this.ID);
    }

    public int getYearsNotPaid() {
        return yearsNotPaid;
    }

    private void setYearsNotPaid() {
        int yrs = LocalDate.now().getYear() - txtaccess.del.getClubStart();
        this.yearsNotPaid = Math.abs(this.years - yrs);
    }

    /**
     * Attaches a Member to this payment.
     */
    private void setMember() {
        this.member = txtaccess.getMember(this.ID);
    }

    private void setName() {
        this.name = this.member.getName();
    }
    
    
}
