package delfinen;

import Logic.CreatePlayer;
import java.sql.Time;
import java.time.LocalDate;

/**
 *
 * @author Malte, Mikkel, Benjamin, Nikolaj
 */
public class Delfinen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // git
        
        System.out.println("Hello Git!");
        System.out.println("new state!");
        System.out.println("I Want My Comp To Run Faster");
        CreatePlayer cp = new CreatePlayer();
        cp.makePlayer("Henrik", LocalDate.of(1994, 04, 10), false, 'M');
    }
    
}
