package za.ac.cput.factory;

import za.ac.cput.util.Helper;
import za.ac.cput.domain.Bill;

/*
BillFactory.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 04 April 2023
 */

public class BillFactory {
    public static Bill createBill(double totalBill){
        if(Helper.isNullOrEmpty(String.valueOf(totalBill))){
            return null;
        }

        String billId = Helper.generateId();

        Bill em = new Bill.Builder().setBillId(billId).setTotalBill(totalBill).build();

        return em;
    }
}
