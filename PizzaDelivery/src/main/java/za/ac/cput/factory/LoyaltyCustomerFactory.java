package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;
import za.ac.cput.domain.LoyaltyCustomer;

import java.time.LocalDate;

/*
LoyaltyCustomerFactory.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 04 April 2023
 */

public class LoyaltyCustomerFactory {

    private static void emailCheck(String email) {
        if (email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            // Email is valid
        } else {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    public static LoyaltyCustomer createLoyaltyCustomer(String customerName, String customerSurname, String phoneNumber, Address address, LocalDate dateJoined, double discounts, String password, String email){
        if(Helper.isNullOrEmpty(customerName) ||
                Helper.isNullOrEmpty(customerSurname) ||
                Helper.isNullOrEmpty(phoneNumber) ||
                Helper.isNullOrEmpty(String.valueOf(address)) ||
                Helper.isNullOrEmpty(String.valueOf(dateJoined)) ||
                Helper.isNullOrEmpty(String.valueOf(password)) ||
                Helper.isNullOrEmpty(String.valueOf(email)) ||
                Helper.isNullOrEmpty(String.valueOf(discounts))){
            return null;
        }

        emailCheck(email);
        Integer customerId = Helper.generateId2();

        LoyaltyCustomer loyaltyCustomer = (LoyaltyCustomer) new LoyaltyCustomer.
               Builder().
               setDateJoined(dateJoined).
               setDiscounts(discounts).
               setPassword(password).

               setEmail(email).
               setCustomerID(customerId).
               setCustomerName(customerName).
               setCustomerSurname(customerSurname).
               setPhoneNumber(phoneNumber).
               setAddress(address).
               build();
       return loyaltyCustomer;
    }

    public static LoyaltyCustomer createLoyaltyCustomer(Integer customerId,String customerName, String customerSurname, String phoneNumber, Address address, LocalDate dateJoined, double discounts, String password, String email){
        if(Helper.isNullOrEmpty(customerName) ||
                Helper.isNullOrEmpty(String.valueOf(customerId)) ||
                Helper.isNullOrEmpty(customerSurname) ||
                Helper.isNullOrEmpty(phoneNumber) ||
                Helper.isNullOrEmpty(String.valueOf(address)) ||
                Helper.isNullOrEmpty(String.valueOf(dateJoined)) ||
                Helper.isNullOrEmpty(String.valueOf(password)) ||
                Helper.isNullOrEmpty(String.valueOf(email)) ||
                Helper.isNullOrEmpty(String.valueOf(discounts))){
            return null;
        }

        emailCheck(email);

        LoyaltyCustomer loyaltyCustomer = (LoyaltyCustomer) new LoyaltyCustomer.
                Builder().
                setDateJoined(dateJoined).
                setDiscounts(discounts).
                setPassword(password).

                setEmail(email).
                setCustomerID(customerId).
                setCustomerName(customerName).
                setCustomerSurname(customerSurname).
                setPhoneNumber(phoneNumber).
                setAddress(address).
                build();
        return loyaltyCustomer;
    }
}

