/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.time.LocalTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Malte
 */
public class MemberTest {
    
    public MemberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getAge method, of class Member.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        String ID = "";
        Member instance = null;
        LocalTime expResult = null;
        LocalTime result = instance.getAge(ID);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Member.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String ID = "";
        Member instance = null;
        String expResult = "";
        String result = instance.getName(ID);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class Member.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        String name = "";
        Member instance = null;
        String expResult = "";
        String result = instance.getID(name);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
