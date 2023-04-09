package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Bill;
import za.ac.cput.factory.BillFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class BillRepositoryTest {

    static Date date = new Date();
    static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    static String strDate = formatter.format(date);
    private static BillRepository repository = BillRepository.getRepository();
    private static Bill bill1 = BillFactory.createBill(strDate,"Magarita",12.0,57.0,684.0,34.0,10.0,584.0);
    private static Bill bill2 = BillFactory.createBill(strDate,"New York",12.0,57.0,684.0,34.0,10.0,584.0);




    @Test
    public void a_create(){
        Bill created1 = repository.create(bill1);
        Bill created2 = repository.create(bill2);
        System.out.println(created1 + "\n" + created2);
        assertNotNull(bill1);
        assertNotNull(bill2);
    }

    @Test
    public void b_read(){
        Bill read1 = repository.read(bill1.getOrderId());
        Bill read2 = repository.read(bill2.getOrderId());
        assertNotNull(read1);
        assertNotNull(read2);
        System.out.println("Read " + read1 + "\n" + read2);
    }

    @Test
    public void c_update(){
        Bill updated = new Bill.Builder().copy(bill1).setMenuItems("Texas").setDiscounts(30.0).build();
        assertNotNull(repository.update(updated));
        System.out.println(updated);
    }

    @Test
    public void d_delete(){
        boolean deleted = repository.delete(bill1.getOrderId());
        assertTrue(deleted);
        System.out.println("Delete " + true);//deleted
    }

    @Test
    public void e_getAll(){
        System.out.println(repository.getAll());

    }
}