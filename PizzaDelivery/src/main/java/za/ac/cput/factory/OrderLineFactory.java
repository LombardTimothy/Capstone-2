package za.ac.cput.factory;

import za.ac.cput.domain.Bill;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderLine;
import za.ac.cput.domain.Pizza;
import za.ac.cput.util.Helper;

/*
OrderLineFactory.java
Author: Tamryn Lisa Lewin (219211981)
Date: 04 April 2023
Last update: 25 September 2023
 */

public class OrderLineFactory {
    public static OrderLine buildOrderLine(int quantity, Order order, Pizza pizza, Bill bill) {
        if(Helper.isNullOrEmpty(String.valueOf(quantity)) || Helper.isNullOrEmpty(String.valueOf(order)) || Helper.isNullOrEmpty(String.valueOf(pizza)) || Helper.isNullOrEmpty(String.valueOf(bill))) {
            return null;
        }

        Integer orderLineId = Helper.generateId2();

        OrderLine orderLine = new OrderLine.Builder()
                .setOrderLineId(orderLineId)
                .setQuantity(quantity)
                .setOrder(order)
                .setPizza(pizza)
                .setBill(bill)
                .build();
        return orderLine;
    }
}
