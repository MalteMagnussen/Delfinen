
package Logic;

import Data.TxtAccess;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nikolaj
 */
public class ControllerTest {
    
    Controller cont = new Controller();
    TxtAccess acc = new TxtAccess();
    
    private int before = 0;
    private int post = 0;
    
    // Test of Show Top 5 Results
    List<String> he = new ArrayList();
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Before
    public void setup() {
        before = acc.getHighestID();
        cont.makePlayer("N", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        //Member insta = new Member("N", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "K");
        cont.makePlayer("N2", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makePlayer("N3", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makePlayer("N4", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makePlayer("N5", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makePlayer("N6", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makePlayer("N7", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makePlayer("N8", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makePlayer("N9", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makePlayer("N10", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        post = acc.getHighestID();
    }
    
    @After
    public void tearDown() {
        int high = acc.getHighestID();
        while(high>1){
            high = acc.getHighestID();
            acc.deleteMember(String.valueOf(high));
            acc.deleteTrainingsResults();
        }
    }
    
    @Test
    public void showTopFiveTest() {
//        he = acc.getAllIDs();
//        Member insta = new Member();
        //List<String> expected = new ArrayList();
        String[] teste;
        //TrainingResults te = new TrainingResults();
        cont.MakeTrainingResult("1", 100, 1.3, LocalDate.now());
        cont.MakeTrainingResult("2", 100, 1.4, LocalDate.now());
        cont.MakeTrainingResult("3", 100, 1.3, LocalDate.now());
        cont.MakeTrainingResult("4", 100, 1.6, LocalDate.now());
        cont.MakeTrainingResult("5", 100, 1.7, LocalDate.now());
        cont.MakeTrainingResult("6", 100, 1, LocalDate.now());
        
        teste = cont.FindTopFiveId(100);
        System.out.println(Arrays.toString(teste));
    }
    
    @Test
    public void negativeFindTopFiveTest() {
        String[] test;
        cont.MakeTrainingResult("1", 100, 0.0, LocalDate.now());
        cont.MakeTrainingResult("2", 100, -1, LocalDate.now());
        cont.MakeTrainingResult("3", 100, -1.4, LocalDate.now());
        cont.MakeTrainingResult("4", 100, -4.1, LocalDate.now());
        cont.MakeTrainingResult("5", 100, 0.1, LocalDate.now());
        cont.MakeTrainingResult("6", 100, -4, LocalDate.now());
        test = cont.FindTopFiveId(100);
        System.out.println(Arrays.toString(test));
    }
}
