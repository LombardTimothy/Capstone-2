package za.ac.cput.factory;

import za.ac.cput.util.Helper;
import za.ac.cput.domain.LoyaltyCustomer;

public class LoyaltyCustomerFactory {


    public static LoyaltyCustomer createLoyaltyCustomer(Double loyaltyPoint, String dateJoined){
        if(Helper.isNullOrEmpty(dateJoined)){
            return null;
        }

        if(Helper.isNullOrEmpty(String.valueOf(loyaltyPoint))){
            return null;
        }

        String loyaltyCustomerId = Helper.generateId();
        String customerId = Helper.generateId();

        LoyaltyCustomer em = new LoyaltyCustomer.Builder().setLoyaltyCustomerId(loyaltyCustomerId).setCustomerId(customerId)
                .setLoyaltyPoint(loyaltyPoint).setDateJoined(dateJoined)
                .build();
        return em;
    }


}

