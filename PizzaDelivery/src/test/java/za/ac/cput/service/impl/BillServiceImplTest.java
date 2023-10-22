package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Bill;
import za.ac.cput.factory.BillFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
BillServiceImplTest.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 09 June 2023
Last updated: 11 June 2023
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class BillServiceImplTest {

    @Autowired
    private BillServiceImpl service = null;

    private static Bill bill1 = BillFactory.createBill(43.3);
    private static Bill bill2 = BillFactory.createBill(23);

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
        Bill readBill1 = service.read(String.valueOf(bill1.getBillId()));
        Bill readBill2 = service.read(String.valueOf(bill2.getBillId()));
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
    void d_delete() {
        boolean deletedBill = service.delete(String.valueOf(bill2.getBillId()));
        assertTrue(deletedBill);
        System.out.println("Deleted successfully: \n" + deletedBill + "\n");
    }

    @Test
    void d_getAll() {
        System.out.println("All: \n" + service.getAll());
    }
}
