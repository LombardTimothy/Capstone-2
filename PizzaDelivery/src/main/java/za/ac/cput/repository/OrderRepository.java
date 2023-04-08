package za.ac.cput.repository;

import za.ac.cput.domain.Order;

import java.util.ArrayList;

/* OrderRepository.java
 Author: Timothy Lombard (220154856)
 Date: 5th April (last updated) 2023
*/

    public class OrderRepository implements IOrderRepository{

        private static za.ac.cput.repository.OrderRepository orderRepo = null;
        private ArrayList<Order> orderDB;
        private OrderRepository(){
            orderDB = new ArrayList<Order>();
        }

        public static za.ac.cput.repository.OrderRepository getRepo(){//singleton, having access to the private constructor
            if(orderRepo == null){
                orderRepo = new za.ac.cput.repository.OrderRepository();
            }
            return orderRepo;
        }

        @Override
        public Order create(Order order) {
            boolean success = orderDB.add(order);
            if(!success) {
                return null;
            }else {
                return order;
            }
        }

        @Override
        public Order read(String orderId) {
            for(Order o : orderDB){
                if(o.getOrderId().equals(orderId))
                    return o;
            }
            return null;
        }

        @Override
        public Order update(Order order) {
            Order oldOrder = read(order.getOrderId());
            if(oldOrder != null){
                orderDB.remove(oldOrder);
                orderDB.add(order);
                return order;
            }
            return null;
        }

        @Override
        public boolean delete(String orderId) {
            Order deleteOrder = read(orderId);
            if(deleteOrder == null){
                System.out.println("Could not delete");
                return false;
            }
            orderDB.remove(deleteOrder);
            System.out.println("Could delete");
            return true;
        }

        @Override
        public ArrayList<Order> getAll(){return orderDB;}
    }



