package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

/*
AddressFactoryTest.java
Author: Tamryn Lisa Lewin (219211981)
Date: 04 April 2023
Last update: 08 April 2023
 */

public class AddressFactoryTest {
    @Test
    public void address_test_pass() {
        Address address = AddressFactory.buildAddress("21", "Jump Street", "Bikini Bottom", "0007", "Ohio", "Westeros");
        System.out.println(address.toString());
        assertNotNull(address);
    }

    @Test
    public void address_test_fail() {
        Address address = AddressFactory.buildAddress("", "Jump Street", "Bikini Bottom", "0007", "Ohio", "Westeros");
        System.out.println(address.toString());
        assertNull(address);
    }

    @Test
    public void address_test_equality_pass() {
        Address address = AddressFactory.buildAddress("21", "Jump Street", "Bikini Bottom", "0007", "Ohio", "Westeros");
        Address address1 = AddressFactory.buildAddress("22", "Fall Street", "Rock Bottom", "0006", "Pennsylvania", "Westeros");
        if(address.equals(address)) {
            System.out.println("Objects are equal.");
        } else
            System.out.println("Objects are not equal.");
    }

    @Test
    public void address_test_equality_fail() {
        Address address = AddressFactory.buildAddress("21", "Jump Street", "Bikini Bottom", "0007", "Ohio", "Westeros");
        Address address1 = AddressFactory.buildAddress("22", "Fall Street", "Rock Bottom", "0006", "Pennsylvania", "Westeros");
        if(address.equals(address1)) {
            System.out.println("Objects are equal.");
        } else
            System.out.println("Objects are not equal.");
    }

    @Test
    public void address_test_timeout_pass() {
        assertTimeoutPreemptively(Duration.ofMillis(2000), () -> {      //pass because test takes less than 2 seconds
            Thread.sleep(1000);
        });

        String streetNumber = "21";
        String streetName = "Jump Street";
        String city = "Bikini Bottom";
        String zipCode = "0007";
        String province = "Ohio";
        String country = "Westeros";

        Address address = AddressFactory.buildAddress("21", "Jump Street", "Bikini Bottom", "0007", "Ohio", "Westeros");
        assertEquals(streetNumber, address.getStreetNumber());
        assertEquals(streetName, address.getStreetName());
        assertEquals(city, address.getCity());
        assertEquals(zipCode, address.getZipCode());
        assertEquals(province, address.getProvince());
        assertEquals(country, address.getCountry());
        System.out.println(address.toString());
    }

    @Test
    public void address_test_timeout_fail() {
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {      //fail because test takes longer than 1 second
            Thread.sleep(2000);
        });

        String streetNumber = "21";
        String streetName = "Jump Street";
        String city = "Bikini Bottom";
        String zipCode = "0007";
        String province = "Ohio";
        String country = "Westeros";

        Address address = AddressFactory.buildAddress("21", "Jump Street", "Bikini Bottom", "0007", "Ohio", "Westeros");
        assertEquals(streetNumber, address.getStreetNumber());
        assertEquals(streetName, address.getStreetName());
        assertEquals(city, address.getCity());
        assertEquals(zipCode, address.getZipCode());
        assertEquals(province, address.getProvince());
        assertEquals(country, address.getCountry());
        System.out.println(address.toString());
    }

    @Disabled("Disabled test.")
    @Test
    public void address_test_disabled() {
        Address address = AddressFactory.buildAddress("21", "Jump Street", "Bikini Bottom", "0007", "Ohio", "Westeros");
        System.out.println(address.toString());
        assertNotNull(address);
    }
}
