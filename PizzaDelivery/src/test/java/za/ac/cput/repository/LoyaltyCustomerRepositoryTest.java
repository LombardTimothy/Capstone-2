package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.LoyaltyCustomer;
import za.ac.cput.factory.LoyaltyCustomerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class LoyaltyCustomerRepositoryTest {

    static Date date = new Date();
    static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    static String strDate = formatter.format(date);
    private static LoyaltyCustomerRepository repository = LoyaltyCustomerRepository.getRepository();
    private static LoyaltyCustomer lc1 = LoyaltyCustomerFactory.createLoyaltyCustomer(35.34,strDate);
    private static LoyaltyCustomer lc2 = LoyaltyCustomerFactory.createLoyaltyCustomer(25.3,strDate);




    @Test
    public void a_create(){
        LoyaltyCustomer created1 = repository.create(lc1);
        LoyaltyCustomer created2 = repository.create(lc2);
        System.out.println(created1 + "\n" + created2);
        assertNotNull(lc1);
        assertNotNull(lc2);
    }

    @Test
    public void b_read(){
        LoyaltyCustomer read1 = repository.read(lc1.getLoyaltyCustomerId());
        LoyaltyCustomer read2 = repository.read(lc2.getLoyaltyCustomerId());
        assertNotNull(read1);
        assertNotNull(read2);
        System.out.println("Read " + read1 + "\n" + read2);
    }

    @Test
    public void c_update(){
        LoyaltyCustomer updated = new LoyaltyCustomer.Builder().copy(lc1).setLoyaltyPoint(65.0).build();
        assertNotNull(repository.update(updated));
        System.out.println(updated);
    }

    @Test
    public void d_delete(){
        boolean deleted = repository.delete(lc1.getLoyaltyCustomerId());
        assertTrue(deleted);
        System.out.println("Delete " + true);//deleted
    }

    @Test
    public void e_getAll(){
        System.out.println(repository.getAll());

    }
}