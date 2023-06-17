package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.OrderRepository;
import za.ac.cput.service.OrderService;

import java.util.ArrayList;
/* OrderServiceImpl.java
 Author: Timothy Lombard (220154856)
 Date: 9th June (last updated) 2023
*/
@Service
public class OrderServiceImpl implements OrderService {

    private static OrderServiceImpl order = null;
    private static OrderRepository repository = null;
    private OrderServiceImpl(){
        repository = OrderRepository.getRepo();
    }

    public static OrderServiceImpl getOrder(){
        if(order == null){
            order = new OrderServiceImpl();
        }
        return  order;
    }


    @Override
    public Order create(Order order) {
        Order created = repository.create(order);
        return created;
    }

    @Override
    public Order read(String orderId) {
        Order readOrder = repository.read(orderId);
        return readOrder;
    }

    @Override
    public Order update(Order order) {
        Order updated = repository.update(order);
        return updated;
    }

    @Override
    public boolean delete(String orderId) {
        boolean success = repository.delete(orderId);
        return success;
    }

    @Override
    public ArrayList<Order> getAll() {
        return repository.getAll();
    }
}
