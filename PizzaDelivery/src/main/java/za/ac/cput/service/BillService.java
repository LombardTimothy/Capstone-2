package za.ac.cput.service;

import za.ac.cput.domain.Bill;

import java.util.Set;

/*
BillService.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 09 June 2023
Last updated: 11 June 2023
 */

public interface BillService extends IService<Bill, String> {
    Bill create(Bill bill);

    Bill read(String orderId);

    Bill update(Bill bill);

    Set<Bill> getAll();
}

