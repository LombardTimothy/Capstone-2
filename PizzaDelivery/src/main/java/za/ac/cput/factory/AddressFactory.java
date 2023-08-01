package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressType;
import za.ac.cput.util.Helper;

/*
AddressFactory.java
Author: Tamryn Lisa Lewin (219211981)
Date: 04 April 2023
Last update: 31 July 2023
 */

public class AddressFactory {
    public static Address buildAddress(String streetNumber, String streetName, String flatNumber, String suburb, String city, String province, String country, String postalCode, AddressType addressType) {
        if(Helper.isNullOrEmpty(streetNumber) || Helper.isNullOrEmpty(streetName) || Helper.isNullOrEmpty(flatNumber) || Helper.isNullOrEmpty(suburb) || Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(province) || Helper.isNullOrEmpty(country) || Helper.isNullOrEmpty(postalCode) || Helper.isNullOrEmpty(String.valueOf(addressType))) {
            return null;
        }

        String addressId = Helper.generateId();

        Address address = new Address.Builder()
                .setAddressId(addressId)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setFlatNumber(flatNumber)
                .setSuburb(suburb)
                .setCity(city)
                .setProvince(province)
                .setCountry(country)
                .setPostalCode(postalCode)
                .setAddressType(addressType)
                .build();
        return address;
    }

    public static Address buildAddress(String streetNumber, String streetName, String suburb, String city, String province, String country, String postalCode, AddressType addressType) {
        if(Helper.isNullOrEmpty(streetNumber) || Helper.isNullOrEmpty(streetName) || Helper.isNullOrEmpty(suburb) || Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(province) || Helper.isNullOrEmpty(country) || Helper.isNullOrEmpty(postalCode) || Helper.isNullOrEmpty(String.valueOf(addressType))) {
            return null;
        }

        String addressId = Helper.generateId();

        Address address = new Address.Builder()
                .setAddressId(addressId)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setSuburb(suburb)
                .setCity(city)
                .setProvince(province)
                .setCountry(country)
                .setPostalCode(postalCode)
                .setAddressType(addressType)
                .build();
        return address;
    }
}
