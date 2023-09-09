package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressType;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

/*
AddressFactoryTest.java
Author: Tamryn Lisa Lewin (219211981)
Date: 04 April 2023
Last update: 05 September 2023
 */

public class AddressFactoryTest {
    @Test
    public void address_test_pass() {
        Address address = AddressFactory.buildAddress("21", "Jump Street", "West Olmstead", "Bikini Bottom", "California", "Crownlands", "0007", AddressType.RESIDENTIAL_HOME);
        System.out.println(address.toString());
        assertNotNull(address);

        Address address2 = AddressFactory.buildAddress("22", "Fall Street", "12", "East Bay", "Rock Bottom", "Ohio", "Crownlands", "0006", AddressType.FLAT_BUILDING);
        System.out.println(address2.toString());
        assertNotNull(address2);
    }

    @Test
    public void address_test_fail() {
        Address address = AddressFactory.buildAddress("", "Jump Street", "West Olmstead", "Bikini Bottom", "California", "Crownlands", "0007", AddressType.RESIDENTIAL_HOME);
        System.out.println(address.toString());
        assertNull(address);
    }

    @Test
    public void address_test_equality_pass() {
        Address address1 = AddressFactory.buildAddress("21", "Jump Street", "West Olmstead", "Bikini Bottom", "California", "Crownlands", "0007", AddressType.RESIDENTIAL_HOME);
        Address address2 = AddressFactory.buildAddress("22", "Fall Street", "12", "East Bay", "Rock Bottom", "Ohio", "Crownlands", "0006", AddressType.FLAT_BUILDING);
        if(address1.equals(address1)) {
            System.out.println("Objects are equal.");
        } else
            System.out.println("Objects are not equal.");
    }

    @Test
    public void address_test_equality_fail() {
        Address address1 = AddressFactory.buildAddress("21", "Jump Street", "West Olmstead", "Bikini Bottom", "California", "Crownlands", "0007", AddressType.RESIDENTIAL_HOME);
        Address address2 = AddressFactory.buildAddress("22", "Fall Street", "12", "East Bay", "Rock Bottom", "Ohio", "Crownlands", "0006", AddressType.FLAT_BUILDING);
        if(address1.equals(address2)) {
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
        String suburb = "West Olmstead";
        String city = "Bikini Bottom";
        String province = "California";
        String country = "Crownlands";
        String postalCode = "0007";
        AddressType addressType = AddressType.RESIDENTIAL_HOME;

        Address address = AddressFactory.buildAddress("21", "Jump Street", "West Olmstead", "Bikini Bottom", "California", "Crownlands", "0007", AddressType.RESIDENTIAL_HOME);
        assertEquals(streetNumber, address.getStreetNumber());
        assertEquals(streetName, address.getStreetName());
        assertEquals(suburb, address.getSuburb());
        assertEquals(city, address.getCity());
        assertEquals(province, address.getProvince());
        assertEquals(country, address.getCountry());
        assertEquals(postalCode, address.getPostalCode());
        assertEquals(addressType, address.getAddressType());
        System.out.println(address.toString());
    }

    @Test
    public void address_test_timeout_fail() {
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {      //fail because test takes longer than 1 second
            Thread.sleep(2000);
        });

        String streetNumber = "21";
        String streetName = "Jump Street";
        String suburb = "West Olmstead";
        String city = "Bikini Bottom";
        String province = "California";
        String country = "Crownlands";
        String postalCode = "0007";
        AddressType addressType = AddressType.RESIDENTIAL_HOME;

        Address address = AddressFactory.buildAddress("21", "Jump Street", "", "West Olmstead", "Bikini Bottom", "California", "Crownlands", "0007", AddressType.RESIDENTIAL_HOME);
        assertEquals(streetNumber, address.getStreetNumber());
        assertEquals(streetName, address.getStreetName());
        assertEquals(suburb, address.getSuburb());
        assertEquals(city, address.getCity());
        assertEquals(province, address.getProvince());
        assertEquals(country, address.getCountry());
        assertEquals(postalCode, address.getPostalCode());
        assertEquals(addressType, address.getAddressType());
        System.out.println(address.toString());
    }

    @Disabled("Disabled test.")
    @Test
    public void address_test_disabled() {
        Address address = AddressFactory.buildAddress("21", "Jump Street", "West Olmstead", "Bikini Bottom", "California", "Crownlands", "0007", AddressType.RESIDENTIAL_HOME);
        System.out.println(address.toString());
        assertNotNull(address);
    }
}
