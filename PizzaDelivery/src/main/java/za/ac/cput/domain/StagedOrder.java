package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/* Order.java
 Entity for the Order
 Author: Timothy Lombard (220154856)
 Date: 4th August (last updated) 2023
*/
@Entity
@Table(name="StagedOrder")
public class StagedOrder {

    public enum OrderStatus{
        NEW, HOLD, SHIPPED, DELIVERED, CLOSED
    }

    @Id
    private Integer orderId;
    private LocalDate createDate;
    private LocalTime time;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerID", referencedColumnName = "customerID")
    private Customer customer;
    private String quantity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Pizza pizza;
    private double total;
    private OrderStatus orderStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pizzeriaID", referencedColumnName = "pizzeriaID")
    private Pizzeria pizzeria;

    protected StagedOrder(){

    }

    private StagedOrder(Builder builder){
        this.orderId = builder.orderId;
        this.createDate = builder.createDate;
        this.time = builder.time;
        this.customer = builder.customer;
        this.orderStatus = builder.orderStatus;
        this.pizzeria = builder.pizzeria;
        this.quantity = builder.quantity;
        this.pizza = builder.pizza;
        this.total = builder.total;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalTime getTime() {
        return time;
    }

    public Customer getCustomer() {
        return customer;
    }
    public Pizza getPizza() {
        return pizza;
    }
    public String getQuantity() {
        return quantity;
    }
    public double getTotal() {
        return total;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Pizzeria getPizzeria() {
        return pizzeria;
    }

    public static class Builder {
        private Integer orderId;
        private LocalDate createDate;
        private LocalTime time;
        private Customer customer;
        private String quantity;
        private Pizza pizza;
        private double total;
        private OrderStatus orderStatus;
        private Pizzeria pizzeria;

        public Builder setOrderId(Integer orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setCreateDate(LocalDate createDate){
            this.createDate = createDate;
            return this;
        }

        public Builder setTime(LocalTime time) {
            this.time = time;
            return this;
        }

        public Builder setCustomer(Customer customer){
            this.customer = customer;
            return this;
        }

        public Builder setQuantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPizza(Pizza pizza){
            this.pizza = pizza;
            return this;
        }
        public Builder setTotal(double total){
            this.total = total;
            return this;
        }

        public Builder setOrderStatus(OrderStatus orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder setPizzeria(Pizzeria pizzeria) {
            this.pizzeria = pizzeria;
            return this;
        }

        public Builder copy(StagedOrder order) {
            this.orderId = order.orderId;
            this.createDate = order.createDate;
            this.time = order.time;
            this.customer = order.customer;
            this.total = order.total;
            this.orderStatus = order.orderStatus;
            this.pizzeria = order.pizzeria;
            this.quantity = order.quantity;
            return this;
        }

        public StagedOrder build() {
            return new StagedOrder(this);
        }
    }


    @Override
    public int hashCode() {
        return Objects.hash(orderId, createDate, time, customer, orderStatus, pizzeria);
    }

    @Override
    public String toString() {
        return "StagedOrder{" +
                "orderId=" + orderId +
                ", createDate=" + createDate +
                ", time=" + time +
                ", customer=" + customer +
                ", quantity='" + quantity + '\'' +
                ", pizza=" + pizza +
                ", total=" + total +
                ", orderStatus=" + orderStatus +
                ", pizzeria=" + pizzeria +
                '}';
    }
}
