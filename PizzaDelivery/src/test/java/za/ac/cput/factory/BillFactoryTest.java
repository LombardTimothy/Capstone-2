package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Bill;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BillFactoryTest {

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    String strDate = formatter.format(date);
    @Test
    public void test(){
        Bill bill = BillFactory.createBill(strDate,"Magarita",12.0,57.0,684.0,34.0,10.0,584.0);
        System.out.print(bill.toString());
        assertNotNull(bill);
    }

    @Test
    public void testFail(){
        Bill bill = BillFactory.createBill(strDate,"",12.0,57.0,684.0,34.0,10.0,584.0);
        System.out.print(bill.toString());
        assertNotNull(bill);
    }



}