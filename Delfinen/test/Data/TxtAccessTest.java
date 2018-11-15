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
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of assignID method, of class TxtAccess.
     */
    @Test
    public void testAssignID() {
        System.out.println("assignID");
        int prehigh = acc.getHighestID();
        cont.makePlayer("Malte", LocalDate.of(1994, Month.OCTOBER, 04), "Lyngby", "maltehviidmagnussen@gmail.com", "42301207", true);
        int posthigh = acc.getHighestID();
        assertEquals(prehigh+1, posthigh);
    }

    /**
     * Test of deleteID method, of class TxtAccess.
     */
    @Test
    public void testDeleteID() {
        System.out.println("deleteID");
        int ID = 0;
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

}
