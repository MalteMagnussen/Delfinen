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
        cont.makePlayer("Malte", LocalDate.of(2005, Month.OCTOBER, 04), "Lyngby", "maltehviidmagnussen@gmail.com", "42301207", true);
        cont.makePlayer("Mikkel", LocalDate.of(2000, Month.NOVEMBER, 05), "Odense", "Mikkel@email.com", "112", true);
        cont.makePlayer("Benjamin", LocalDate.of(1990, Month.JUNE, 05), "Kbh", "Benjamin@email.com", "123123", true);
        cont.makePlayer("Nikolaj", LocalDate.of(1995, Month.JANUARY, 05), "Vejle", "Nikolaj@email.com", "1278", true);
        post = acc.getHighestID();
    }

    @After
    public void tearDown() {
        while(acc.getHighestID()>0){
            acc.deleteMember(String.valueOf(acc.getHighestID()));
        }
        
    }

    /**
     * Test of assignID method, of class TxtAccess.
     */
    @Test
    public void testAssignID() {
        System.out.println("assignID");
        assertEquals(pre+4, post);
    }
    
    
    // TO DO EVERYTHING BELOW AND MORE 
    
    /**
     * Test of deleteID method, of class TxtAccess.
     */
    @Test
    public void testDeleteID() {
        System.out.println("deleteID");
        String ID = "";
        TxtAccess instance = new TxtAccess();
        instance.deleteID(ID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of getHighestID method, of class TxtAccess.
//     */
//    @Test
//    public void testGetHighestID() {
//        System.out.println("getHighestID");
//        TxtAccess instance = new TxtAccess();
//        int expResult = 0;
//        int result = instance.getHighestID();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of payment method, of class TxtAccess.
//     */
//    @Test
//    public void testPayment() {
//        System.out.println("payment");
//        Integer ID = null;
//        TxtAccess instance = new TxtAccess();
//        instance.payment(ID);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
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
//        // TODO review the generated test code and remove the default call to fail.
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
//        // TODO review the generated test code and remove the default call to fail.
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
//        // TODO review the generated test code and remove the default call to fail.
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
//        // TODO review the generated test code and remove the default call to fail.
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
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
