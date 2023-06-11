package za.ac.cput.service.impl;

import za.ac.cput.domain.Bill;
import za.ac.cput.domain.LoyaltyCustomer;
import za.ac.cput.repository.BillRepository;
import za.ac.cput.repository.LoyaltyCustomerRepository;
import za.ac.cput.service.BillService;
import za.ac.cput.service.LoyaltyCustomerService;

import java.util.Set;

/*
LoyaltyCustomerServiceImpl.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 09 June 2023
Last updated: 11 June 2023
 */

public class LoyaltyCustomerServiceImpl implements LoyaltyCustomerService {
    private static LoyaltyCustomerServiceImpl service = null;
    private static LoyaltyCustomerRepository repository = null;
    private LoyaltyCustomerServiceImpl() {

        repository = LoyaltyCustomerRepository.getRepository();
    }

    public static LoyaltyCustomerServiceImpl getService() {
        if (service == null) {
            service = new LoyaltyCustomerServiceImpl();
        }
        return service;
    }

    @Override
    public LoyaltyCustomer create(LoyaltyCustomer loyaltyCustomer) {
        LoyaltyCustomer createdLoyaltyCustomer = repository.create(loyaltyCustomer);
        return createdLoyaltyCustomer;
    }

    @Override
    public LoyaltyCustomer read(String loyaltyCustomerId) {
        LoyaltyCustomer readLoyaltyCustomer = repository.read(loyaltyCustomerId);
        return readLoyaltyCustomer;
    }

    @Override
    public LoyaltyCustomer update(LoyaltyCustomer loyaltyCustomer) {
        LoyaltyCustomer updatedLoyaltyCustomer = repository.update(loyaltyCustomer);
        return updatedLoyaltyCustomer;
    }

    @Override
    public Set<LoyaltyCustomer> getAll() {
        return repository.getAll();
    }

}


