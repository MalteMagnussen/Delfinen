
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

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
        pre = acc.getHighestID();
        cont.makePlayer("Malte", LocalDate.of(2005, Month.OCTOBER, 04), "Lyngby", "maltehviidmagnussen@gmail.com", "42301207", true, "");
        cont.makePlayer("Mikkel", LocalDate.of(2000, Month.NOVEMBER, 05), "Odense", "Mikkel@email.com", "112", true, "");
        cont.makePlayer("Benjamin", LocalDate.of(1990, Month.JUNE, 05), "Kbh", "Benjamin@email.com", "123123", true, "");
        cont.makePlayer("Nikolaj", LocalDate.of(1995, Month.JANUARY, 05), "Vejle", "Nikolaj@email.com", "1278", true, "");
        post = acc.getHighestID();
    }

    @After
    public void tearDown() {
        int high = acc.getHighestID();
        while(high>1){
            high = acc.getHighestID();
            acc.deleteMember(String.valueOf(high));
        }
    }

    // NOTE TO SELF
    // Arrange
    // Act
    // Assert

    /**
     * Test of assignID method, of class TxtAccess.
     */
    @Test
    public void testAssignID() {
        System.out.println("assignID");
        assertEquals(pre+4, post);
    }
    
    /**
     * Test of deleteID method, of class TxtAccess.
     */
    @Test
    public void testDeleteID(){
        int o = acc.getHighestID();
        cont.makePlayer("DeleteID", LocalDate.of(1995, Month.JANUARY, 05), "Vejle", "Nikolaj@email.com", "1278", true, "");
        Member member = acc.getMemberByName("DeleteID");
        int p = acc.getHighestID();
        assertEquals(o+1,p);        
        acc.deleteMember(member.getID());
        List<Member> members = acc.getMembers();
        int k = members.size();
        assertEquals(o,k);
    }
    
    /**
     * Test of getHighestID method, of class TxtAccess.
     */
    @Test
    public void testGetHighestID(){
        int o = acc.getHighestID();
        cont.makePlayer("HighestID", LocalDate.of(1995, Month.JANUARY, 05), "Vejle", "Nikolaj@email.com", "1278", true, "");
        Member member = acc.getMemberByName("HighestID");
        int p = acc.getHighestID();
        assertEquals(o+1,p);        
        acc.deleteMember(member.getID());
        int k = acc.getHighestID();
        assertEquals(o,k);
    }
    
    /**
     * Test of payment method, of class TxtAccess.
     */
    @Test
    public void testPayment(){
        Member member = acc.getMemberByName("Malte");
        String ID = member.getID();
        int payment = acc.findPayment(ID);
        acc.payment(ID);
        int postpayment = acc.findPayment(ID);
        assertEquals(payment+1,postpayment);
    }
    
    // TO - DO more tests and better tests.
//
//    /**
//     * Test of getMember method, of class TxtAccess.
//     */
//    @Test
//    public void testGetMember() {
//        System.out.println("getMember");
//        String ID = "";
//        TxtAccess instance = new TxtAccess();
//        Member expResult = null;
//        Member result = instance.getMember(ID);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteMember method, of class TxtAccess.
//     */
//    @Test
//    public void testDeleteMember() {
//        System.out.println("deleteMember");
//        String ID = "";
//        TxtAccess instance = new TxtAccess();
//        instance.deleteMember(ID);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMembers method, of class TxtAccess.
//     */
//    @Test
//    public void testGetMembers() {
//        System.out.println("getMembers");
//        TxtAccess instance = new TxtAccess();
//        List<Member> expResult = null;
//        List<Member> result = instance.getMembers();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAllIDs method, of class TxtAccess.
//     */
//    @Test
//    public void testGetAllIDs() {
//        System.out.println("getAllIDs");
//        TxtAccess instance = new TxtAccess();
//        ArrayList<String> expResult = null;
//        ArrayList<String> result = instance.getAllIDs();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setMembers method, of class TxtAccess.
//     */
//    @Test
//    public void testSetMembers() {
//        System.out.println("setMembers");
//        List<Member> members = null;
//        TxtAccess instance = new TxtAccess();
//        instance.setMembers(members);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findPayment method, of class TxtAccess.
//     */
//    @Test
//    public void testFindPayment() {
//        System.out.println("findPayment");
//        String ID = "";
//        TxtAccess instance = new TxtAccess();
//        int expResult = 0;
//        int result = instance.findPayment(ID);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of initializePayment method, of class TxtAccess.
//     */
//    @Test
//    public void testInitializePayment() {
//        System.out.println("initializePayment");
//        Member member = null;
//        TxtAccess instance = new TxtAccess();
//        instance.initializePayment(member);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteAllPayments method, of class TxtAccess.
//     */
//    @Test
//    public void testDeleteAllPayments() {
//        System.out.println("deleteAllPayments");
//        String ID = "";
//        TxtAccess instance = new TxtAccess();
//        instance.deleteAllPayments(ID);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTraningResults method, of class TxtAccess.
//     */
//    @Test
//    public void testGetTraningResults() {
//        System.out.println("getTraningResults");
//        TxtAccess instance = new TxtAccess();
//        List<TraningResults> expResult = null;
//        List<TraningResults> result = instance.getTraningResults();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setTraningResults method, of class TxtAccess.
//     */
//    @Test
//    public void testSetTraningResults() {
//        System.out.println("setTraningResults");
//        List<TraningResults> traningResults = null;
//        TxtAccess instance = new TxtAccess();
//        instance.setTraningResults(traningResults);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMemberByName method, of class TxtAccess.
//     */
//    @Test
//    public void testGetMemberByName() {
//        System.out.println("getMemberByName");
//        String name = "";
//        TxtAccess instance = new TxtAccess();
//        Member expResult = null;
//        Member result = instance.getMemberByName(name);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCompetitions method, of class TxtAccess.
//     */
//    @Test
//    public void testGetCompetitions() {
//        System.out.println("getCompetitions");
//        TxtAccess instance = new TxtAccess();
//        List<Competitions> expResult = null;
//        List<Competitions> result = instance.getCompetitions();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setCompetition method, of class TxtAccess.
//     */
//    @Test
//    public void testSetCompetition() {
//        System.out.println("setCompetition");
//        List<Competitions> name = null;
//        TxtAccess instance = new TxtAccess();
//        instance.setCompetition(name);
//        fail("The test case is a prototype.");
//    }
//    
}
