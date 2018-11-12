
package Data;

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
    Map<String, Boolean> payment = new HashMap<>();

    public Member(String name, LocalTime age, String ID, boolean status) {
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.status = status;
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
    
    
}
