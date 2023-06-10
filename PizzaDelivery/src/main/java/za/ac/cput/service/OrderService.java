package za.ac.cput.service;

import za.ac.cput.domain.Order;
import za.ac.cput.repository.OrderRepository;

import java.util.ArrayList;
/* OrderService.java
 Author: Timothy Lombard (220154856)
 Date: 9th June (last updated) 2023
*/
public class OrderService implements IOrderService{

    private static OrderService order = null;
    private static OrderRepository repository = null;
    private OrderService(){
        repository = OrderRepository.getRepo();
    }

    public static OrderService getOrder(){
        if(order == null){
            order = new OrderService();
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
