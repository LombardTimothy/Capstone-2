package za.ac.cput.repository;

import za.ac.cput.domain.Order;

import java.util.ArrayList;

/* IOrderRepository.java
 Author: Timothy Lombard (220154856)
 Date: 5th April (last updated) 2023
*/


    public interface IOrderRepository extends IRepository<Order, String>{
        //Order replaces T and the String replaces ID from the IRepository interface
        // it is extends because it's from 1 interface to another

        Order create(Order order);

        Order read(String orderId);

        Order update(Order order);

        boolean delete(String orderId);

        public ArrayList<Order> getAll();


    }

