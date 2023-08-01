package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressType;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerAddress;

import static org.junit.jupiter.api.Assertions.*;

class CustomerAddressFactoryTest {

    private static Address address = AddressFactory.buildAddress("22", "Fall Street", "12", "East Bay", "Rock Bottom", "Ohio", "Crownlands", "0006", AddressType.FLAT_BUILDING);
    private static Customer customer = CustomerFactory.buildCustomer("Rickon", "Stark","076 675 8090", address);
    private static CustomerAddress customerAddress = CustomerAddressFactory.buildCustomerAddress(customer, address);

    @Test
    public void success(){
        System.out.println(customerAddress.toString());
        assertNotNull(customerAddress);
    }

}