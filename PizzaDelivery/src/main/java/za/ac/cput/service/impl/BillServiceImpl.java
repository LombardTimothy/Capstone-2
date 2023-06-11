package za.ac.cput.service.impl;

import za.ac.cput.domain.Bill;
import za.ac.cput.repository.BillRepository;
import za.ac.cput.service.BillService;

import java.util.Set;

/*
BillServiceImpl.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 09 June 2023
Last updated: 11 June 2023
 */

public class BillServiceImpl implements BillService {
    private static BillServiceImpl service = null;
    private static BillRepository repository = null;
    private BillServiceImpl() {
        repository = BillRepository.getRepository();
    }

    public static BillServiceImpl getService() {
        if (service == null) {
            service = new BillServiceImpl();
        }
        return service;
    }

    @Override
    public Bill create(Bill bill) {
        Bill createdBill = repository.create(bill);
        return createdBill;
    }

    @Override
    public Bill read(String orderId) {
        Bill readBill = repository.read(orderId);
        return readBill;
    }

    @Override
    public Bill update(Bill bill) {
        Bill updatedBill = repository.update(bill);
        return updatedBill;
    }

    @Override
    public Set<Bill> getAll() {
        return repository.getAll();
    }
}

