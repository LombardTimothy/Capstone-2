package za.ac.cput.service;

import za.ac.cput.domain.Order;

import java.util.ArrayList;
/* IOrderService.java
 Author: Timothy Lombard (220154856)
 Date: 9th June (last updated) 2023
*/

public interface IOrderService extends IService<Order, String>{

    Order create(Order order);

    Order read(String orderId);

    Order update(Order order);

    boolean delete(String orderId);

    public ArrayList<Order> getAll();
}
