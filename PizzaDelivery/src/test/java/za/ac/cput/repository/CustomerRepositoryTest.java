
package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CustomerFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

/*
   CustomerRepositoryTest.java
   Entity for the CustomerRepositoryTest
   Author: Keenan Meyer (220194920)
   Date: 03th April 2023
*/
@TestMethodOrder(MethodOrderer.MethodName.class)

public class CustomerRepositoryTest {
    public static Address address = AddressFactory.buildAddress(
            "7",
            "Delft",
            "Cape Town",
            "2134",
            "Western Cape",
            "South Africa");
    public static Address address2 = AddressFactory.buildAddress(
            "10",
            "Belhar",
            "Cape Town",
            "2154",
            "Western Cape",
            "South Africa");
    public static Address address3 = AddressFactory.buildAddress(
            "8",
            "Delft",
            "Cape Town",
            "2134",
            "Western Cape",
            "South Africa");
    private static CustomerRepository repo = CustomerRepository.getRepo();

    private static Customer customer = CustomerFactory.buildCustomer(
            "Keenan",
            "Meyer",
            address);

    private static Customer customer2 = CustomerFactory.buildCustomer(
            "Alison",
            "Williams",
            address2);

    private static Customer customer3= CustomerFactory.buildCustomer(
            "Brandon",
            "Wise",
            address3);


    @Test
    public void a_Customer_create(){
        Customer created = repo.create(customer);
        Customer created1 = repo.create(customer2);
        Customer created2 = repo.create(customer3);

        System.out.println(created + "\n" + created1 + "\n" + created2);

        assertNotNull(customer);
        assertNotNull(customer2);
        assertNotNull(customer3);
    }

    @Test
    public void b_Customer_read(){
        Customer read = repo.read(customer.getCustomerID());
        Customer read1 = repo.read(customer2.getCustomerID());
        Customer read2 = repo.read(customer3.getCustomerID());

        assertNotNull(read);
        assertNotNull(read1);
        assertNotNull(read2);

        System.out.println("Read " + read + "\n" + read1 + "\n" + read2);
    }

    @Test
    public void c_Customer_update(){
        Customer updated = new Customer.Builder().copy(customer2).setCustomerName("Keenan").setCustomerSurname("Joy").setAddress(address2).build();
        assertNotNull(repo.update(updated));
        System.out.println(updated);
    }

    @Test
    public void d_Customer_delete(){
        boolean deleted = repo.delete(customer.getCustomerID());
        assertTrue(deleted);
        System.out.println("Delete " + true);//deleted
    }

    @Test
    public void e_Customer_getAll(){
        System.out.println(repo.getAll());

    }
}
