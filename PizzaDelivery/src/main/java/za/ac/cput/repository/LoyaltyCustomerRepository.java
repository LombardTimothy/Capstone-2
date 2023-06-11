package za.ac.cput.repository;

import java.util.HashSet;
import java.util.Set;
import za.ac.cput.domain.LoyaltyCustomer;

/*
   LoyaltyCustomerRepository.java
   Repository for the LoyaltyCustomer class
   Author: Vuyisa Lutho Mqoboli (219191018)
   Date: 8th April 2023
*/
public class LoyaltyCustomerRepository implements ILoyaltyCustomerRepository{

    private static LoyaltyCustomerRepository repository = null;
    private Set<LoyaltyCustomer> loyaltyCustomerList;

    private LoyaltyCustomerRepository()
    {
        loyaltyCustomerList = new HashSet<LoyaltyCustomer>();
    }

    public static LoyaltyCustomerRepository getRepository(){
        if(repository == null)
            repository = new LoyaltyCustomerRepository();
        return repository;
    }
    @Override
    public LoyaltyCustomer create(LoyaltyCustomer loyaltyCustomer) {
        boolean success = loyaltyCustomerList.add(loyaltyCustomer);
        if(!success)
            return null;
        return loyaltyCustomer;
    }

    @Override
    public LoyaltyCustomer read(String loyaltyCustomerId) {
        for (LoyaltyCustomer e: loyaltyCustomerList
        ) {
            if(e.getLoyaltyCustomerId().equals(loyaltyCustomerId))
                return e;


        } return null;
    }

    @Override
    public LoyaltyCustomer update(LoyaltyCustomer loyaltyCustomer) {
        LoyaltyCustomer buffer = read(loyaltyCustomer.getLoyaltyCustomerId());
        if(buffer != null) {
            loyaltyCustomerList.remove(buffer);
            loyaltyCustomerList.add(loyaltyCustomer);
            return loyaltyCustomer;
        }
        return null;
    }

    @Override
    public boolean delete(String loyaltyCustomerId) {
        LoyaltyCustomer loyaltyCustomer = read(loyaltyCustomerId);
        if(loyaltyCustomer == null)
            return false;
        loyaltyCustomerList.remove(loyaltyCustomer);
        return true;
    }
    @Override
    public Set<LoyaltyCustomer> getAll() {
        return loyaltyCustomerList;
    }

}

