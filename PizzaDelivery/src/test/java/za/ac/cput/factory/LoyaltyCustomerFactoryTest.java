package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressType;
import za.ac.cput.domain.LoyaltyCustomer;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoyaltyCustomerFactoryTest {

    private static Address address = AddressFactory.buildAddress("10", "Long Street", "West Side", "Sandy Shores", "California", "Georgia", "9274", AddressType.RESIDENTIAL_HOME);
    LocalDate date = LocalDate.now();

    @Test
    public void test(){
        LoyaltyCustomer lc = LoyaltyCustomerFactory.createLoyaltyCustomer(
                "Sam",
                "Doe",
                "078-675-7850",
                address,
                date,
                50.55,
                "123456790",
                "giveon@gmail.com"
        );
        System.out.print(lc.toString());
        assertNotNull(lc);
    }

    @Test
    public void testFail(){
        LoyaltyCustomer lc = LoyaltyCustomerFactory.createLoyaltyCustomer(
                "",
                "Wise",
                "078-675-7850",
                address,
                date,
                50.55,
                "",
                "4");
        System.out.print(lc.toString());
        assertNotNull(lc);
    }
}
