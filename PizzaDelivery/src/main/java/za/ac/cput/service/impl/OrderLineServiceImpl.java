package za.ac.cput.service.impl;

import za.ac.cput.domain.OrderLine;
import za.ac.cput.repository.OrderLineRepository;
import za.ac.cput.service.OrderLineService;

import java.util.ArrayList;

/*
OrderLineServiceImpl.java
Author: Tamryn Lisa Lewin (219211981)
Date: 09 June 2023
Last updated: 10 June 2023
 */

public class OrderLineServiceImpl implements OrderLineService {
    private static OrderLineServiceImpl service = null;
    private static OrderLineRepository repository = null;
    private OrderLineServiceImpl() {
        repository = OrderLineRepository.getRepository();
    }

    public static OrderLineServiceImpl getService() {
        if (service == null) {
            service = new OrderLineServiceImpl();
        }
        return service;
    }

    @Override
    public OrderLine create(OrderLine orderLine) {
        OrderLine createdOrderLine = repository.create(orderLine);
        return createdOrderLine;
    }

    @Override
    public OrderLine read(String orderLineId) {
        OrderLine readOrderLine = repository.read(orderLineId);
        return readOrderLine;
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        OrderLine updatedOrderLine = repository.update(orderLine);
        return updatedOrderLine;
    }

    @Override
    public boolean delete(String orderLineId) {
        boolean deletedOrderLine = repository.delete(orderLineId);
        return deletedOrderLine;
    }

    @Override
    public ArrayList<OrderLine> getAll() {
        return repository.getAll();
    }
}
