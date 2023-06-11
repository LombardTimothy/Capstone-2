package za.ac.cput.service;

import za.ac.cput.domain.LoyaltyCustomer;

import java.util.Set;

/*
LoyaltyCustomerService.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 09 June 2023
Last updated: 11 June 2023
 */

public interface LoyaltyCustomerService extends IService<LoyaltyCustomer, String> {
    LoyaltyCustomer create(LoyaltyCustomer loyaltyCustomer);

    LoyaltyCustomer read(String loyaltyCustomerId);

    LoyaltyCustomer update(LoyaltyCustomer loyaltyCustomer);

    Set<LoyaltyCustomer> getAll();
}

