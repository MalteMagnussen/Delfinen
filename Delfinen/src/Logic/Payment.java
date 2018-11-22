/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.TxtAccess;
import java.time.LocalDate;
import java.util.Objects;

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

    /**
     * Make a Payment.
     *
     * The Constructor assigns everything automatically based on the Member.
     *
     * @param ID of the Member whose payment this is.
     *
     */
    public Payment(String ID) {
        this.ID = ID;
        setMember();
        setName();
        setYears();
        setYearsNotPaid();
        setAmountOwed();
    }

    /**
     * Used to print pretty to GUI.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Navn: " + name
                + " År: " + yearsNotPaid
                + " At Betale: " + amountOwed
                + "\n";
    }

    public int getYears() {
        return years;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Calculates the total debt.
     */
    private void setAmountOwed() {
        Controller cont = new Controller();
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

    /**
     * From the other info available we can calculate how many years this person
     * hasn't paid for yet.
     */
    private void setYearsNotPaid() {
        // Years since club started.
        int yrs = LocalDate.now().getYear() - txtaccess.del.getClubStart();
        // Years since club started minus years that has been paid.
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Payment other = (Payment) obj;
        if (this.years != other.years) {
            return false;
        }
        if (this.yearsNotPaid != other.yearsNotPaid) {
            return false;
        }
        if (this.amountOwed != other.amountOwed) {
            return false;
        }
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
