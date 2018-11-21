
package Logic;

import Data.TxtAccess;
import java.time.LocalDate;
import java.time.Month;
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
    
    static Controller cont = new Controller();
    static TxtAccess acc = new TxtAccess();
    
    static List<Competition> liste;
    
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
        cont.makeMember("N", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        //Member insta = new Member("N", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "K");
        cont.makeMember("N2", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makeMember("N3", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makeMember("N4", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makeMember("N5", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makeMember("N6", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makeMember("N7", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makeMember("N8", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makeMember("N9", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        cont.makeMember("N10", LocalDate.of(1994, 03, 02), "hed", "gah", "1325", true, "Crawl");
        post = acc.getHighestID();
    }
    
    @After
    public void tearDown() {
        acc.resetAllFiles();
    }
    
    @Test
    public void showTopFiveTest() {
        String[] teste;
        cont.MakeTrainingResult("1", 100, 1.3, LocalDate.now());
        cont.MakeTrainingResult("2", 100, 1.4, LocalDate.now());
        cont.MakeTrainingResult("3", 100, 1.3, LocalDate.now());
        cont.MakeTrainingResult("4", 100, 1.6, LocalDate.now());
        cont.MakeTrainingResult("5", 100, 1.7, LocalDate.now());
        cont.MakeTrainingResult("6", 100, 1, LocalDate.now());
        
        teste = cont.FindTopFiveId(100, "2");
        System.out.println(Arrays.toString(teste));
    }
    
    
    // Negativ Test over Find Top 5 
    @Test
    public void negativeFindTopFiveTest() {
        String[] test;
        cont.MakeTrainingResult("1", 100, 0.0, LocalDate.now());
        cont.MakeTrainingResult("2", 100, -1, LocalDate.now());
        cont.MakeTrainingResult("3", 100, -1.4, LocalDate.now());
        cont.MakeTrainingResult("4", 100, -4.1, LocalDate.now());
        cont.MakeTrainingResult("5", 100, 0.1, LocalDate.now());
        cont.MakeTrainingResult("6", 100, -4, LocalDate.now());
        test = cont.FindTopFiveId(100, "2");
        System.out.println(Arrays.toString(test));
    }
    
    // Test Of Registrrer Competition in controller and getCompetition in TxtAccess
    @Test
    public void testCompetitionRegistrer() {
        cont.competitionRegistrer("OLYMPIC", LocalDate.of(2001, Month.MARCH, 15));
        try {
            liste = acc.getCompetitions();
            for(int i = 0; i < liste.size(); ++i) {
                if(liste.get(i).getName().equals("OLYMPIC") && liste.get(i).getLocalDate().equals(LocalDate.of(2001, Month.MARCH, 15))){
                    return;
                }
            }
        } catch(Exception e) {
            // NOT EXPECTED 
            System.out.println("Excepion");
        }
    }
    
    // Test of get Non Paid 
    @Test
    public void testGetNonPaid() {
        try {
            Payment pay = new Payment("1");
            String non;
            for(int i = 0; i < cont.getNonPaid().length(); ++i) {
                non = cont.getNonPaid();
                if(non.equals("N")) { return; }
            }
        } catch(Exception e){
            
        }
    }
    
    // Test Of Get Amount Owned
    @Test
    public void testGetAmount(){
        int not = 1;
        Member mem = new Member("N8", LocalDate.of(2007, Month.MARCH, 1), true, "Crawl");
        int expected = 1000;
        int result = cont.getAmount(not, mem);
        assertEquals(expected, result);
        
        not = 2;
        expected = 2000;
        result = cont.getAmount(not, mem);
        assertEquals(expected, result);
    }
    
//    // Negative Test Of Get Amount Owned
//    @Test
//    public void negativeTestGetAmount(){
//        try {
//        int not = -1;
//        Member mem = new Member("7", LocalDate.of(2007, Month.MARCH, 1), true, "Crawl");
//        int expected = 0;
//        int result = cont.getAmount(not, mem);
//        } catch(Exception e) {
//            // Expected
//            System.out.println("Exception Catched");
//        }
//    }
    
    // Test Of Change Member
    @Test
    public void testChangeMemberType() {
        // Testing the boolean about if you are active or not
        boolean before = false;
        boolean result;
        Member mem = new Member("N9", LocalDate.of(2007, Month.MARCH, 1), before, "Crawl");
        String id  = "7";
        boolean expected = true;
        String type = "Butterfly";
        try {
            cont.changeMember(id, expected, type);
            result = acc.getMemberByName("N9").isStatus();
            assertEquals(expected, result);
        } catch(Exception e) {
            System.out.println("ChangeMember");
        }
        
//        // Testing boolean about if you are active or not
//        before = true;
//        expected = false;
//        type = "Breast";
//        try {
//            System.out.println(before + " " + expected + " " + type);
//            cont.changeMember(id, expected, type);
//            System.out.println(acc.getMemberByName("N9"));
//            result = acc.getMemberByName("N9").isStatus();
//            System.out.println(result);
//            assertEquals(expected, result);
//        } catch(Exception e) {
//            System.out.println("ChangeMember");
//        }
    }
    
    // Testing change member by type 
    @Test
    public void testChangeMemberByType() {
        String before = "Crawl";
        Member mem = new Member("N9", LocalDate.of(2007, Month.MARCH, 1), true, before);
        String id = "7";
    }
}
