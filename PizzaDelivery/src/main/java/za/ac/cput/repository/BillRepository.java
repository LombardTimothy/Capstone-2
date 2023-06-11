package za.ac.cput.repository;

import java.util.HashSet;
import java.util.Set;
import za.ac.cput.domain.Bill;

/*
   BillRepository.java
   Repository for the Bill class
   Author: Vuyisa Lutho Mqoboli (219191018)
   Date: 8th April 2023
*/
public class BillRepository implements IBillRepository{

    private static BillRepository repository = null;
    private Set<Bill> billList = null;

    private BillRepository()
    {
        billList = new HashSet<Bill>();
    }
    public static BillRepository getRepository(){
        if(repository == null)
            repository = new BillRepository();
        return repository;
    }
    @Override
    public Bill create(Bill bill) {
        boolean success = billList.add(bill);
        if(!success)
            return null;
        return bill;
    }

    @Override
    public Bill read(String billId) {
        for (Bill e: billList
        ) {
            if(e.getBillId().equals(billId))
                return e;


        } return null;
    }

    @Override
    public Bill update(Bill bill) {
        Bill buffer = read(bill.getBillId());
        if(buffer != null) {
            billList.remove(buffer);
            billList.add(bill);
            return bill;
        }
        return null;
    }

    @Override
    public boolean delete(String billId) {
        Bill bill = read(billId);
        if(bill == null)
            return false;
        billList.remove(bill);
        return true;
    }
    @Override
    public Set<Bill> getAll() {
        return billList;
    }

}
