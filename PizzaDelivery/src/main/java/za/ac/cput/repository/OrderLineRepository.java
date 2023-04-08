package za.ac.cput.repository;

import za.ac.cput.domain.OrderLine;
import java.util.ArrayList;

/*
OrderLineRepository.java
Author: Tamryn Lisa Lewin (219211981)
Date: 05 April 2023
Last update: 08 April 2023
 */

public class OrderLineRepository implements IOrderLineRepository {
    private static OrderLineRepository orderLineRepository = null;
    private ArrayList<OrderLine> orderLineDB;
    private OrderLineRepository() {
        orderLineDB = new ArrayList<OrderLine>();
    }

    public static OrderLineRepository getRepository() {
        if(orderLineRepository == null) {
            orderLineRepository = new OrderLineRepository();
        }
        return orderLineRepository;
    }

    @Override
    public OrderLine create(OrderLine orderLine) {
        boolean success = orderLineDB.add(orderLine);
        if(!success) {
            return null;
        }else
            return orderLine;
    }

    @Override
    public OrderLine read(String orderLineId) {
        for(OrderLine o : orderLineDB) {
            if(o.getOrderLineId().equals(orderLineId))
                return o;
        }
        return null;
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        OrderLine currentOrderLine = read(orderLine.getOrderLineId());
        if(currentOrderLine != null) {
            orderLineDB.remove(currentOrderLine);
            orderLineDB.add(orderLine);
            return orderLine;
        }
        return null;
    }

    @Override
    public boolean delete(String orderLineId) {
        OrderLine deleteOrderLine = read(orderLineId);
        if(deleteOrderLine != null) {
            orderLineDB.remove(deleteOrderLine);
            System.out.println("Deleted.");
            return true;
        }else {
            System.out.println("Could not delete.");
            return false;
        }
    }

    @Override
    public ArrayList<OrderLine> getAll() {
        return orderLineDB;
    }
}
