package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderLine;
import za.ac.cput.domain.Pizza;
import za.ac.cput.util.Helper;

/*
OrderLineFactory.java
Author: Tamryn Lisa Lewin (219211981)
Date: 04 April 2023
Last update: 08 April 2023
 */

public class OrderLineFactory {
    public static OrderLine buildOrderLine(int quantity, Order order, Pizza pizza) {
        if(Helper.isNullOrEmpty(String.valueOf(quantity)) || Helper.isNullOrEmpty(String.valueOf(order)) || Helper.isNullOrEmpty(String.valueOf(pizza))) {
            return null;
        }

        String orderLineId = Helper.generateId();

        OrderLine orderLine = new OrderLine.Builder()
                .setOrderLineId(orderLineId)
                .setQuantity(quantity)
                .setOrder(order)
                .setPizza(pizza)
                .build();
        return orderLine;
    }
}
