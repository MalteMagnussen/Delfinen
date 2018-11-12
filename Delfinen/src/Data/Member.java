
package Data;

import Logic.DataAccessor;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Malte
 */
public class Member implements Swimmer{
    private String name;
    private LocalDate birthday;
    private String ID;
    private boolean status;
    private LocalTime joinDate;
    
    Map<String, Boolean> payment = new HashMap<>();

    public Member(String name, LocalDate birthday, boolean status, char MK) {
        this.name = name;
        this.birthday = birthday;
        this.status = status;
        this.ID = "" + MK + createID(); // Assigns ID.
        
    }

    // Returns the Age, not the Birthday.
    @Override
    public int getAge() {        
        int year = birthday.getYear();
        int currentYear = LocalDate.now().getYear();
        int age = Math.abs(year-currentYear);
        
        return age; 
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    // Gets highest ID and adds one to it so you have can assign that to the member.
    private int createID() {
        DBConnector connector = null;
        DataAccessor data = new DataAccessor(connector);
        int highestID = data.getHighestID();
        return highestID +1 ;
    }

    // Testing Purposes and for when you EDIT member. First you DELETE member, 
    // then you create a new member with the old info and then new edited info,
    // but the same old ID, meaning that you need a setID to set the ID to what-
    // ever it was before.
    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public int getYearJoined() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
