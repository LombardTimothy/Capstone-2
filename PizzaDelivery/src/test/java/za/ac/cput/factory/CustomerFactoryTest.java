package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerFactoryTest {
    public static Address address = AddressFactory.buildAddress(
            "7th Street",
            "Delft",
            "Cape Town",
            "2134",
            "Western Cape",
            "South Africa");
    @Test
    void buildCustomer() {
        Customer customer = CustomerFactory.buildCustomer("Keenan", "Meyer", address);
        System.out.println(customer.toString());
        assertNotNull(customer);
    }

}
