package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.LoyaltyCustomer;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LoyaltyCustomerFactoryTest {

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    String strDate = formatter.format(date);
    @Test
    public void test(){
        LoyaltyCustomer lc = LoyaltyCustomerFactory.createLoyaltyCustomer(35.34,strDate);
        System.out.print(lc.toString());
        assertNotNull(lc);
    }

    @Test
    public void testFail(){
        LoyaltyCustomer lc = LoyaltyCustomerFactory.createLoyaltyCustomer(36.47,"");
        System.out.print(lc.toString());
        assertNotNull(lc);
    }



}