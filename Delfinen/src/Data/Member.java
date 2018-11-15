package Data;

import Logic.DataAccessor;
import Logic.TxtAccess;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Malte
 */
public class Member implements Swimmer {

    private String name;
    private LocalDate birthday;
    private String ID;
    private boolean status;
    private int joinDate;
    ArrayList<Integer> payment = new ArrayList<>();

    public Member(String name, LocalDate birthday, boolean status, char MK) {
        this.name = name;
        this.birthday = birthday;
        this.status = status;
        this.joinDate = LocalDate.now().getYear();
        initializePayments();
    }

    public Member(String name, int age, boolean status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Returns the Age, not the Birthday.
    @Override
    public int getAge() {
        int year = birthday.getYear();
        int currentYear = LocalDate.now().getYear();
        int age = Math.abs(year - currentYear);

        return age;
    }
    
    // Called by the 'Kasserer' when someone has paid him for a year.
    public void addPayment(int year){
        payment.add(year);
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    // Only used when you edit a member.
    // Because you basically delete the old member and make a new one,
    // but with the same ID.
    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public int getYearJoined() {
        return this.joinDate;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    
    // Everyone has 'paid' for the years that they've not been a member.
    // This adds the years that they weren't a member of the club
    // to the "Years Paid" array. 
    private void initializePayments() {
        int clubStartDate = 2010;
        for (int i = 0; i < joinDate-clubStartDate ; i++){
            payment.add(clubStartDate + i);
        }
    }

    public boolean isStatus() {
        return status;
    }
    
    // If you call this, you flip the status of the member.
    public void setStatus() {
        if (status == true) this.status = false;
        status = true;
    }
    
    public void setID(int newID) {
        this.ID = String.valueOf(newID);
    }

}
