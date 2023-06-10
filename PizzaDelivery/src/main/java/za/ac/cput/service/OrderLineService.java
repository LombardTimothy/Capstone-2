package za.ac.cput.service;

import za.ac.cput.domain.OrderLine;

import java.util.ArrayList;

public interface OrderLineService extends IService<OrderLine, String> {
    OrderLine create(OrderLine orderLine);
    OrderLine read(String orderLineId);
    OrderLine update(OrderLine orderLine);
    boolean delete(String orderLineId);
    ArrayList<OrderLine> getAll();
}
