
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
        cont.makePlayer("Nikolaj", LocalDate.of(1995, Month.JANUARY, 05), "Vejle", "Nikolaj@email.com", "1278", true, "");
        
        
        
    }
    
    
}
