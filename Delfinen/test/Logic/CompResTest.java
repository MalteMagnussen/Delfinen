/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.TxtAccess;
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
public class CompResTest {
    
    private TxtAccess acc;
    
    public CompResTest() {
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
        acc.resetAllFiles();
    }

    /**
     * Test of getid method, of class CompRes.
     */
    @Test
    public void testGetid() {
        System.out.println("getid");
        CompRes instance = null;
        String expResult = "";
        String result = instance.getid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompetition method, of class CompRes.
     */
    @Test
    public void testGetCompetition() {
        System.out.println("getCompetition");
        CompRes instance = null;
        Competition expResult = null;
        Competition result = instance.getCompetition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlacement method, of class CompRes.
     */
    @Test
    public void testGetPlacement() {
        System.out.println("getPlacement");
        CompRes instance = null;
        int expResult = 0;
        int result = instance.getPlacement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
