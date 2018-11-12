
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
    
    
}
