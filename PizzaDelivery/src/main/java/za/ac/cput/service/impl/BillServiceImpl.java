package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Bill;
import za.ac.cput.repository.IBillRepository;
import za.ac.cput.service.BillService;
import java.util.Set;
import java.util.stream.Collectors;

/*
BillServiceImpl.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 09 June 2023
Last updated: 11 June 2023
 */

@Service
public class BillServiceImpl implements BillService {
    private IBillRepository repository;

    @Autowired
    private BillServiceImpl(IBillRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bill create(Bill bill) {
        return this.repository.save(bill);
    }

    @Override
    public Bill read(String billId) {
        return this.repository.findById(billId).orElse(null);
    }

    @Override
    public Bill update(Bill bill) {
        if (this.repository.existsById(bill.getBillId())) {
            return this.repository.save(bill);
        }
        return null;
    }

    @Override
    public boolean delete(String billId) {
        if (this.repository.existsById(billId)) {
            this.repository.deleteById(billId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Bill> getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}


