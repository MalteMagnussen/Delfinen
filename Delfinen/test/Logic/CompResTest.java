/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.TxtAccess;
import java.time.LocalDate;
import java.time.Month;
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
    Competition comp = new Competition ( "kbh", LocalDate.of(2015, Month.MARCH, 10));
    CompRes compres = new CompRes("1", comp, 1);
    
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
        /* 
            Set up some Members.
            Set up some Competitions.
            Set up some Results.
            Then you can use these to test on.
        */
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of getid method, of class CompRes.
     */
    @Test
    public void testGetid() {
        System.out.println("getid");
        assertEquals("1", compres.getID());
    }

    /**
     * Test of getPlacement method, of class CompRes.
     */
    @Test
    public void testGetPlacement() {
        System.out.println("getPlacement");
        assertEquals(1, compres.getPlacement());
    }
    
}
