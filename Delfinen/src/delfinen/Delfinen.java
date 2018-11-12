package delfinen;

import Logic.CreatePlayer;
import java.time.LocalTime;

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
        cp.makePlayer("edsfa", LocalTime.now(), false, 'M');
    }
    
}
