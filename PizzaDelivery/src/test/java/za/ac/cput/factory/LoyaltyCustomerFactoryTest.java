package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.LoyaltyCustomer;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LoyaltyCustomerFactoryTest {

    LocalDate date = LocalDate.now();

    @Test
    public void test(){
        LoyaltyCustomer lc = LoyaltyCustomerFactory.createLoyaltyCustomer(date, 54.3);
        System.out.print(lc.toString());
        assertNotNull(lc);
    }

    @Test
    public void testFail(){
        LoyaltyCustomer lc = LoyaltyCustomerFactory.createLoyaltyCustomer(date, 0);
        System.out.print(lc.toString());
        assertNotNull(lc);
    }



}