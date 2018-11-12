
package Data;

import Logic.DataAccessor;
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
    private LocalDate age;
    private String ID;
    private boolean status;
    private LocalTime joinDate;
    
    Map<String, Boolean> payment = new HashMap<>();

    public Member(String name, LocalDate age, boolean status, char MK) {
        this.name = name;
        this.age = age;
        this.status = status;
        this.ID = "" + MK + createID(); // Assigns ID.
        
    }

    @Override
    public LocalTime getAge(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName(String ID) {
        return this.name;
    }

    @Override
    public String getID(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void setID(String ID) {
        this.ID = ID;
    }
    
    
}
