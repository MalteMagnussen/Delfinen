/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.Member;
import Logic.Controller;
import java.sql.Time;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Malte
 */
public class MemberTest {

    Member instance = new Member("Richard", LocalDate.of(1994, 10, 04), false, "");

    public MemberTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @Before
    public void setUp() {

    }

    // What's needed for Member:
    // String name, LocalTime age, boolean status, char MK
    /**
     * Test of getAge method, of class Member.
     */
    @Test
    public void testGetAge() {
        int expResult = 24;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Member.
     */
    @Test
    public void testGetName() {
        String expResult = "Richard";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getID method, of class Member.
     */
    @Test
    public void testGetID() {
        String expResult = null;
        String result = instance.getID();
        assertEquals(expResult, result);
    }
    
    // Negative Test of name
    @Test
    public void negativeTestGetName() {
    try {
        Member instance = new Member("", LocalDate.of(1994, 30, 12), false, "");
        String result = instance.getName();
    }  catch(Exception e) {
    // Expected
        
      }
    }
    
    // Negative Test of age
    @Test
    public void negativeTestGetAge() {
        try {
            Member instance = new Member("Richard", LocalDate.of(0000, -1, 00), false, "");
            String result = Integer.toString(instance.getAge());
        } catch(Exception e) {
            // Expected
        }
    }
        

}
