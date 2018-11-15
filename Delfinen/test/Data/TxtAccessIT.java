/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.Member;
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
public class TxtAccessIT {
    
    public TxtAccessIT() {
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
        Member member = null;
        TxtAccess instance = new TxtAccess();
        instance.assignID(member);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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

    /**
     * Test of getHighestID method, of class TxtAccess.
     */
    @Test
    public void testGetHighestID() {
        System.out.println("getHighestID");
        TxtAccess instance = new TxtAccess();
        int expResult = 0;
        int result = instance.getHighestID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of payment method, of class TxtAccess.
     */
    @Test
    public void testPayment() {
        System.out.println("payment");
        Integer ID = null;
        TxtAccess instance = new TxtAccess();
        instance.payment(ID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMember method, of class TxtAccess.
     */
    @Test
    public void testGetMember() {
        System.out.println("getMember");
        String ID = "";
        TxtAccess instance = new TxtAccess();
        Member expResult = null;
        Member result = instance.getMember(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllIDs method, of class TxtAccess.
     */
    @Test
    public void testGetAllIDs() {
        System.out.println("getAllIDs");
        TxtAccess instance = new TxtAccess();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("1");
        expResult.add("2");
        expResult.add("3");
        ArrayList<String> result = new ArrayList<>();
        result = instance.getAllIDs();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMembers method, of class TxtAccess.
     */
    @Test
    public void testGetMembers() {
        System.out.println("getMembers");
        TxtAccess instance = new TxtAccess();
        List<Member> expResult = null;
        List<Member> result = instance.getMembers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
