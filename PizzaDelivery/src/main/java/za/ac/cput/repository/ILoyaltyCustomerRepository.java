package za.ac.cput.repository;

import za.ac.cput.domain.LoyaltyCustomer;

import java.util.Set;

public interface ILoyaltyCustomerRepository extends IRepository<LoyaltyCustomer, String> {
    public Set<LoyaltyCustomer> getAll();
}

