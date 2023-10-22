package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.IOrderRepository;
import za.ac.cput.service.OrderService;

import java.util.ArrayList;

/* OrderServiceImpl.java
 Author: Timothy Lombard (220154856)
 Date: 30th July (last updated) 2023
*/

@Service
public class OrderServiceImpl implements OrderService {
    private IOrderRepository orderRepo;
    @Autowired
    private OrderServiceImpl(IOrderRepository orderRepo){
        this.orderRepo = orderRepo;
    }

    @Override
    public Order create(Order order) {
        return this.orderRepo.save(order);
    }

    @Override
    public Order read(Integer id) {
        return this.orderRepo.findById(id).orElse(null);
    }

    @Override
    public Order update(Order order) {
        if(this.orderRepo.existsById(order.getOrderId())){
            return this.orderRepo.save(order);
        }else{
            return null;
        }

    }

    @Override
    public boolean delete(Integer id) {
        if(this.orderRepo.existsById(id)){
            this.orderRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Order> getAll(){return (ArrayList<Order>) this.orderRepo.findAll();}
}
