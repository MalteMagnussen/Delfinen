
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.Competition;
import Logic.Controller;
import Logic.Member;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Malte
 */
public class TxtAccessTest {

    Controller cont = new Controller();
    TxtAccess acc = new TxtAccess();
    private int pre = 0;
    private int post = 0;
    List<Competition> competitions = new ArrayList<>();

    public TxtAccessTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pre = acc.getHighestID(); // Used in testAssignID()
        cont.makeMember("Malte", LocalDate.of(2005, Month.OCTOBER, 04), "Lyngby", "maltehviidmagnussen@gmail.com", "42301207", true, "");
        cont.makeMember("Mikkel", LocalDate.of(2000, Month.NOVEMBER, 05), "Odense", "Mikkel@email.com", "112", true, "");
        cont.makeMember("Benjamin", LocalDate.of(1990, Month.JUNE, 05), "Kbh", "Benjamin@email.com", "123123", true, "");
        cont.makeMember("Nikolaj", LocalDate.of(1995, Month.JANUARY, 05), "Vejle", "Nikolaj@email.com", "1278", true, "");
        Competition kbh = new Competition("kbh", LocalDate.of(1990, Month.OCTOBER, 10));
        Competition aarhus = new Competition("aarhus", LocalDate.of(2000, Month.OCTOBER, 10));
        Competition aalborg = new Competition("aalborg", LocalDate.of(2010, Month.OCTOBER, 10));
        competitions.add(kbh);
        competitions.add(aarhus);
        competitions.add(aalborg);
        post = acc.getHighestID(); // Used in testAssignID()
    }

    @After
    public void tearDown() {
        acc.resetAllFiles();
    }

    // NOTE TO SELF
    // Arrange
    // Act
    // Assert
    
    
    
    /**
     * Test of setCompetition and getCompetitions methods of class TxtAccess.
     */
    @Test
    public void testGetCompetitions(){
        acc.setCompetition(competitions);
        List<Competition> competitiontest = acc.getCompetitions();
        assertEquals(competitions.get(0).getName(), competitiontest.get(0).getName());
        assertEquals(competitions.get(1).getLocalDate(), competitiontest.get(1).getLocalDate());
        assertEquals(competitions.get(2).getName(), competitiontest.get(2).getName());
        
    }
    
    /**
     * Test of assignID method, of class TxtAccess.
     */
    @Test
    public void testAssignID() {
        System.out.println("assignID"); 
        assertEquals(pre + 4, post); 
    }

    /**
     * Test of deleteID method, of class TxtAccess.
     */
    @Test
    public void testDeleteID() {
        int o = acc.getHighestID(); // Pre Highest ID
        cont.makeMember("DeleteID", LocalDate.of(1995, Month.JANUARY, 05), "Vejle", "Nikolaj@email.com", "1278", true, "");
        // ^ Makes a Member and it gets an ID automatically Assigned.
        Member member = acc.getMemberByName("DeleteID"); // Makes an instance we can work on.
        int p = acc.getHighestID(); // Post Highest ID
        assertEquals(o + 1, p); // Check whether the person really got an ID automatically. 
        acc.deleteMember(member.getID()); // Delete the Member.
        List<Member> members = acc.getMembers(); // make a list we can check length on.
        int k = members.size(); // Check if the member really got deleted.
        assertEquals(o, k);
    }

    /**
     * Test of getHighestID method, of class TxtAccess.
     */
    @Test
    public void testGetHighestID() {
        int o = acc.getHighestID(); // gets the pre HighestID
        cont.makeMember("HighestID", LocalDate.of(1995, Month.JANUARY, 05), "Vejle", "Nikolaj@email.com", "1278", true, "");
        // ^ Make a new player, and it gets automatically assigned a new ID. 
        Member member = acc.getMemberByName("HighestID"); // Creates the member by name. We know the name.
        int p = acc.getHighestID(); // Gets the new highest ID.
        assertEquals(o + 1, p); // Tests whether the pre+1 is equal to the post.
        acc.deleteMember(member.getID()); // Now I delete the member, so that function is also tested.
        int k = acc.getHighestID(); // Gets the post highest ID.
        assertEquals(o, k);
    }

    /**
     * Test of payment method, of class TxtAccess.
     */
    @Test
    public void testPayment() {
        Member member = acc.getMemberByName("Malte"); // Find a member that I made in the test setup.
        String ID = member.getID(); // Get the members ID so we can use that for the other methods.
        int payment = acc.findPayment(ID); // This finds out how many years the member has paid for before we add one to it.
        acc.payment(ID);  // This adds one year to the members payments.
        int postpayment = acc.findPayment(ID); // This finds out how many years the member has paid for after we add one to it.
        assertEquals(payment + 1, postpayment); // If it works, the prepayment+1 should be equal to the postpayment.
    }
    
    
}
