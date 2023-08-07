package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.LoyaltyCustomer;
import za.ac.cput.repository.ILoyaltyCustomerRepository;
import za.ac.cput.service.LoyaltyCustomerService;
import java.util.Set;

/*
LoyaltyCustomerServiceImpl.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 09 June 2023
Last updated: 11 June 2023
 */

@Service
public class LoyaltyCustomerServiceImpl implements LoyaltyCustomerService {
    private ILoyaltyCustomerRepository repository;

    @Autowired
    private LoyaltyCustomerServiceImpl(ILoyaltyCustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public LoyaltyCustomer create(LoyaltyCustomer loyaltyCustomer) {
        return this.repository.save(loyaltyCustomer);
    }

    @Override
    public LoyaltyCustomer read(String loyaltyCustomerId) {
        return this.repository.findById(loyaltyCustomerId).orElse(null);
    }

    @Override
    public LoyaltyCustomer update(LoyaltyCustomer loyaltyCustomer) {
        if (this.repository.existsById(loyaltyCustomer.getLoyaltyCustomerId())) {
            return this.repository.save(loyaltyCustomer);
        }
        return null;
    }

    @Override
    public boolean delete(String loyaltyCustomerId) {
        if (this.repository.existsById(loyaltyCustomerId)) {
            this.repository.deleteById(loyaltyCustomerId);
            return true;
        }
        return false;
    }

    @Override
    public Set<LoyaltyCustomer> getAll() {
        return (Set<LoyaltyCustomer>) this.repository.findAll();
    }
}

