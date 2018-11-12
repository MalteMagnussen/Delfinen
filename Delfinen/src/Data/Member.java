
package Data;

import Logic.DataAccessor;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Malte
 */
public class Member implements Swimmer{
    private String name;
    private LocalTime age;
    private String ID;
    private boolean status;
    private LocalTime joinDate;
    
    Map<String, Boolean> payment = new HashMap<>();

    public Member(String name, LocalTime age, boolean status, char MK) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    
}
