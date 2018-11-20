/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.TxtAccess;

/**
 *
 * @author Malte
 */
public class Payment {
    private int years; // Years Paid since clubstart.
    private String ID; // ID of the Member.
    private int yearsNotPaid; // Years left to pay.
    private int amountOwed; // Amount owed.
    private String name; // name of Member.
    private TxtAccess acc;
    
    public Payment(String ID) {
        this.ID = ID;
        this.name = acc.getMember(ID).getName();
    }

    @Override
    public String toString() {
        return name + yearsNotPaid + amountOwed + "\n";
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getYearsNotPaid() {
        return yearsNotPaid;
    }

    public void setYearsNotPaid(int yearsNotPaid) {
        this.yearsNotPaid = yearsNotPaid;
    }

    public int getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(int amountOwed) {
        this.amountOwed = amountOwed;
    }
    
    
}
