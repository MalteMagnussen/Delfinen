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
        cont.makeMember("Malte", LocalDate.of(1990, Month.OCTOBER, 04), "Lyngby", "maltehviidmagnussen@gmail.com", "42301207", false, "Crawl");
    }

    @AfterClass
    public static void tearDown() {
        acc.resetAllFiles();
    }

    /**
     * Test of class Payment.
     */
    @Test
    public void testPayment() {
        Payment payment = new Payment("1");
        assertEquals(0, payment.getYearsNotPaid());
        assertEquals(0, payment.getAmountOwed());
        String toString = "Navn: " + payment.getName() + " År: " + payment.getYearsNotPaid() + " At Betale: " + payment.getAmountOwed() + "\n";
        assertEquals(toString, payment.toString());

        payment = new Payment("2");
        assertEquals(0, payment.getYearsNotPaid());
        assertEquals(0, payment.getAmountOwed());
    }
}
