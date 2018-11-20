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
        /* 
            Set up some Members.
            Set up some Competitions.
            Set up some Results.
            Then you can use these to test on.
        */
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
        
    }

    /**
     * Test of getCompetition method, of class CompRes.
     */
    @Test
    public void testGetCompetition() {
        System.out.println("getCompetition");
        
    }

    /**
     * Test of getPlacement method, of class CompRes.
     */
    @Test
    public void testGetPlacement() {
        System.out.println("getPlacement");
        
    }
    
}
