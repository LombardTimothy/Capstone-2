package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Bill;
import za.ac.cput.domain.LoyaltyCustomer;
import za.ac.cput.factory.BillFactory;
import za.ac.cput.factory.LoyaltyCustomerFactory;
import za.ac.cput.repository.LoyaltyCustomerRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/*
LoyaltyCustomerServiceImplTest.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 09 June 2023
Last updated: 10 June 2023
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
class LoyaltyCustomerServiceImplTest {

    private static LoyaltyCustomerServiceImpl service = null;

    static LocalDate dateNow = LocalDate.now();
    private static LoyaltyCustomerRepository repository = LoyaltyCustomerRepository.getRepository();
    private static LoyaltyCustomer lc1 = LoyaltyCustomerFactory.createLoyaltyCustomer(dateNow,35.34);
    private static LoyaltyCustomer lc2 = LoyaltyCustomerFactory.createLoyaltyCustomer(dateNow,25.3);


    private LoyaltyCustomerServiceImplTest() {
        service = LoyaltyCustomerServiceImpl.getService();
    }


    @Test
    public void a_create(){
        LoyaltyCustomer created1 = repository.create(lc1);
        LoyaltyCustomer created2 = repository.create(lc2);
        System.out.println("Create"+ "\n" +created1 + "\n" + created2+ "\n");
        assertNotNull(lc1);
        assertNotNull(lc2);
    }

    @Test
    public void b_read(){
        LoyaltyCustomer read1 = repository.read(lc1.getLoyaltyCustomerId());
        LoyaltyCustomer read2 = repository.read(lc2.getLoyaltyCustomerId());
        assertNotNull(read1);
        assertNotNull(read2);
        System.out.println("Read "+ "\n" +read1 + "\n" + read2+ "\n");
    }

    @Test
    public void c_update(){
        LoyaltyCustomer updated = new LoyaltyCustomer.Builder().copy(lc1).setDiscounts(30).build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated"+ "\n" +updated+ "\n");
    }

    @Test
    public void e_getAll(){
        System.out.println("Get all"+ "\n" +repository.getAll());

    }
}

