package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Bill;
import za.ac.cput.factory.BillFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
BillServiceImplTest.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 09 June 2023
Last updated: 11 June 2023
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
class BillServiceImplTest {

    private static BillServiceImpl service = null;

    private static Bill bill1 = BillFactory.createBill(43.3);
    private static Bill bill2 = BillFactory.createBill(23);

    private BillServiceImplTest() {
        service = BillServiceImpl.getService();
    }

    @Test
    void a_create() {
        Bill createdBill1 = service.create(bill1);
        Bill createdBill2 = service.create(bill2);
        assertNotNull(createdBill1);
        assertNotNull(createdBill2);
        System.out.println("Created: \n" + createdBill1 + "\n" + createdBill2 + "\n");
    }

    @Test
    void b_read() {
        Bill readBill1 = service.read(bill1.getBillId());
        Bill readBill2 = service.read(bill2.getBillId());
        assertNotNull(readBill1);
        assertNotNull(readBill2);
        System.out.println("Read: \n" + readBill1 + "\n" + readBill2 + "\n");
    }

    @Test
    void c_update() {
        Bill updatedBill = new Bill.Builder().copy(bill1).setTotalBill(435).build();
        assertNotNull(service.update(updatedBill));
        System.out.println("Updated: \n" + updatedBill + "\n");
    }

    @Test
    void d_getAll() {
        System.out.println("All: \n" + service.getAll());
    }
}

