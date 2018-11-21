/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

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
public class PaymentTest {
    
    public PaymentTest() {
    }
    
    

    /**
     * Test of toString method, of class Payment.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Payment instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYears method, of class Payment.
     */
    @Test
    public void testGetYears() {
        System.out.println("getYears");
        Payment instance = null;
        int expResult = 0;
        int result = instance.getYears();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setYears method, of class Payment.
     */
    @Test
    public void testSetYears() {
        System.out.println("setYears");
        int years = 0;
        Payment instance = null;
        instance.setYears(years);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYearsNotPaid method, of class Payment.
     */
    @Test
    public void testGetYearsNotPaid() {
        System.out.println("getYearsNotPaid");
        Payment instance = null;
        int expResult = 0;
        int result = instance.getYearsNotPaid();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setYearsNotPaid method, of class Payment.
     */
    @Test
    public void testSetYearsNotPaid() {
        System.out.println("setYearsNotPaid");
        int yearsNotPaid = 0;
        Payment instance = null;
        instance.setYearsNotPaid(yearsNotPaid);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmountOwed method, of class Payment.
     */
    @Test
    public void testGetAmountOwed() {
        System.out.println("getAmountOwed");
        Payment instance = null;
        int expResult = 0;
        int result = instance.getAmountOwed();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmountOwed method, of class Payment.
     */
    @Test
    public void testSetAmountOwed() {
        System.out.println("setAmountOwed");
        int amountOwed = 0;
        Payment instance = null;
        instance.setAmountOwed(amountOwed);
        fail("The test case is a prototype.");
    }
    
}
