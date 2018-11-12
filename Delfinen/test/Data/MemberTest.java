/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

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
        System.out.println("getAge");
        String ID = "";
        LocalDate age = LocalDate.of(1994, 10, 04);
        Member instance = new Member("Richard", age, false, 'M');
        int expResult = 24;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Member.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        LocalDate age = LocalDate.of(1994,10,04);
        Member instance = new Member("Richard", age, false, 'M');
        instance.setID(ID);
        String expResult = "Richard";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getID method, of class Member.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        String name = "Richard";
        LocalDate age = LocalDate.of(1994,10,04);
        Member instance = new Member(name, age, false, 'M');
        String expResult = "M1";
        String result = instance.getID();
        assertEquals(expResult, result);
    }
    
}
