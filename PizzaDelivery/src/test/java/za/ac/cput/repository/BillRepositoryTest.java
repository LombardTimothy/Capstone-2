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

    private static BillRepository repository = BillRepository.getRepository();
    private static Bill bill1 = BillFactory.createBill(984.0);
    private static Bill bill2 = BillFactory.createBill(454.0);




    @Test
    public void a_create(){
        Bill created1 = repository.create(bill1);
        Bill created2 = repository.create(bill2);
        System.out.println("Create"+ "\n" +created1 + "\n" + created2+ "\n");
        assertNotNull(bill1);
        assertNotNull(bill2);
    }

    @Test
    public void b_read(){
        Bill read1 = repository.read(bill1.getBillId());
        Bill read2 = repository.read(bill2.getBillId());
        assertNotNull(read1);
        assertNotNull(read2);
        System.out.println("Read " + "\n" + read1 + "\n" + read2 + "\n");
    }

    @Test
    public void c_update(){
        Bill updated = new Bill.Builder().copy(bill1).setTotalBill(1850).build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated"+ "\n" +updated+ "\n");
    }

    @Test
    public void d_delete(){
        boolean deleted = repository.delete(bill1.getBillId());
        assertTrue(deleted);
        System.out.println("Delete " + deleted+ "\n");//deleted
    }

    @Test
    public void e_getAll(){
        System.out.println("Get all"+ "\n" +repository.getAll());

    }
}