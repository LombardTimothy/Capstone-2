package za.ac.cput.domain;

import java.util.Objects;

/*
OrderLine.java
OrderLine entity
Author: Tamryn Lisa Lewin (219211981)
Date: 04 April 2023
Last update: 08 April 2023
 */

public class OrderLine {
    private String orderLineId;
    private int quantity;
    private Order order;
    private Pizza pizza;

    private OrderLine() {}

    private OrderLine(Builder builder) {
        this.orderLineId = builder.orderLineId;
        this.quantity = builder.quantity;
        this.order = builder.order;
        this.pizza = builder.pizza;
    }

    public String getOrderLineId() {
        return orderLineId;
    }
    public int getQuantity() {
        return quantity;
    }
    public Order getOrder() {
        return order;
    }
    public Pizza getPizza() {
        return pizza;
    }

    public static class Builder {
        private String orderLineId;
        private int quantity;
        private Order order;
        private Pizza pizza;

        public Builder setOrderLineId(String orderLineId) {
            this.orderLineId = orderLineId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setOrder(Order order) {
            this.order = order;
            return this;
        }
        public Builder setPizza(Pizza pizza) {
            this.pizza = pizza;
            return this;
        }

        public Builder copy(OrderLine orderLine) {
            this.orderLineId = orderLine.orderLineId;
            this.quantity = orderLine.quantity;
            this.order = orderLine.order;
            this.pizza = orderLine.pizza;
            return this;
        }

        public OrderLine build() {
            return new OrderLine(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return quantity == orderLine.quantity && orderLineId.equals(orderLine.orderLineId) && order.equals(orderLine.order) && pizza.equals(orderLine.pizza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderLineId, quantity, order, pizza);
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "orderLineId='" + orderLineId + '\'' +
                ", quantity=" + quantity +
                ", order=" + order +
                ", pizza=" + pizza +
                '}';
    }
}
