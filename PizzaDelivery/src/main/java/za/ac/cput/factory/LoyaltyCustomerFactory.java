package za.ac.cput.factory;

import za.ac.cput.util.Helper;
import za.ac.cput.domain.LoyaltyCustomer;

import java.time.LocalDate;

/*
LoyaltyCustomerFactory.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 04 April 2023
 */


public class LoyaltyCustomerFactory {
    public static LoyaltyCustomer createLoyaltyCustomer(LocalDate dateJoined, double discounts){
        if(Helper.isNullOrEmpty(String.valueOf(dateJoined)) || Helper.isNullOrEmpty(String.valueOf(discounts))){
            return null;
        }

        String loyaltyCustomerId = Helper.generateId();

        LoyaltyCustomer em = new LoyaltyCustomer.Builder().setLoyaltyCustomerId(loyaltyCustomerId)
                .setDateJoined(dateJoined).setDiscounts(discounts)
                .build();
        return em;
    }
}

