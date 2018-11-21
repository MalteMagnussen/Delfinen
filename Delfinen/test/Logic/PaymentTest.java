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
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Malte
 */
public class PaymentTest {
    
    private static Controller cont = new Controller();
    private static TxtAccess acc = new TxtAccess();
    
    
    public PaymentTest() {
    }
    
    @BeforeClass
    public static void setUp() {
        cont.makeMember("Malte", LocalDate.of(1990, Month.OCTOBER, 04), "Lyngby", "maltehviidmagnussen@gmail.com", "42301207", true, "Crawl");
        cont.makeMember("Mikkel", LocalDate.of(1990, Month.NOVEMBER, 05), "Odense", "Mikkel@email.com", "112", true, "Crawl");
        cont.makeMember("Benjamin", LocalDate.of(1990, Month.JUNE, 05), "Kbh", "Benjamin@email.com", "123123", true, "Crawl");
        cont.makeMember("Nikolaj", LocalDate.of(1990, Month.JANUARY, 05), "Vejle", "Nikolaj@email.com", "1278", true, "Crawl");
        cont.makeMember("Atlas", LocalDate.of(2015, Month.MARCH, 05), "kbh", "buildabear", "12121212", true, "Crawl");
    }

    @AfterClass
    public static void tearDown() {
        acc.resetAllFiles();
    }

    
   
    
    /**
     * Test of getYearsNotPaid Method of class Payment.
     */
    @Test
    public void testgetYearsNotPaid(){ 
        Payment payment;
        payment = new Payment("1");
        payment.setYearsNotPaid(1);
        assertEquals(1, payment.getYearsNotPaid());
    }

    /**
     * Test of getAmountOwed Method of class Payment.
     */
    @Test
    public void testgetAmountOwed(){
        // Arrange
         Payment payment;
        payment = new Payment("2");
        
        // Act
        payment.setAmountOwed(1000);
        // Assert
        assertEquals(1000, payment.getAmountOwed());
        
        // Act
        payment.setAmountOwed(10000);
        // Assert
        assertEquals(10000, payment.getAmountOwed());
    }
    
    /** 
     * Test of getYears Method of class Payment. 
     */
    @Test
    public void testgetYears(){
        Payment payment = new Payment("3");
        
        payment.setYears(1);
        assertEquals(1, payment.getYears());
        
        payment.setYears(1000);
        assertEquals(1000, payment.getYears());
    }

}
