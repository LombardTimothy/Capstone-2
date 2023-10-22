package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.StagedOrder;
import za.ac.cput.repository.StagedOrderRepository;
import za.ac.cput.service.StagedOrderService;
import java.util.ArrayList;

@Service
public class StagedOrderServiceImpl implements StagedOrderService{
    private StagedOrderRepository repository;
    @Autowired
    private StagedOrderServiceImpl(StagedOrderRepository repository){
        this.repository = repository;
    }

    @Override
    public StagedOrder create(StagedOrder stagedOrder) {
        return this.repository.save(stagedOrder);
    }

    @Override
    public StagedOrder read(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public StagedOrder update(StagedOrder order) {
        if(this.repository.existsById(order.getOrderId())){
            return this.repository.save(order);
        }else{
            return null;
        }
    }

    @Override
    public boolean delete(Integer id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<StagedOrder> getAll(){
        return (ArrayList<StagedOrder>) this.repository.findAll();}
 }
