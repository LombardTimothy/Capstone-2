package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/* Order.java
 Entity for the Order
 Author: Timothy Lombard (220154856)
 Date: 30th July (last updated) 2023
*/
@Entity
    public class Order {

    public enum OrderStatus{
        NEW, HOLD, SHIPPED, DELIVERED, CLOSED
    }

    @Id
        private String orderId;

        private LocalDate createDate;
        private LocalTime time;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerID", referencedColumnName = "customerID")
        private Customer customer;

    private OrderStatus orderStatus;



        protected Order(){

        }

        private Order(Builder builder){
            this.orderId = builder.orderId;
            this.createDate = builder.createDate;
            this.time = builder.time;
            this.customer = builder.customer;
            this.orderStatus = builder.orderStatus;
        }

        public String getOrderId() {
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public static class Builder {
            private String orderId;
            private LocalDate createDate;
            private LocalTime time;
            private Customer customer;
            private OrderStatus orderStatus;


            public za.ac.cput.domain.Order.Builder setOrderId(String orderId) {
                this.orderId = orderId;
                return this;
            }

            public za.ac.cput.domain.Order.Builder setCreateDate(LocalDate createDate){
                this.createDate = createDate;
                return this;
            }

            public Builder setTime(LocalTime time) {
                this.time = time;
                return this;
            }

            public Order.Builder setCustomer(Customer customer){
                this.customer = customer;
                return this;
            }

        public Order.Builder setOrderStatus(OrderStatus orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public za.ac.cput.domain.Order.Builder copy(za.ac.cput.domain.Order order) {
                this.orderId = order.orderId;
                this.createDate = order.createDate;
                this.time = order.time;
                this.customer = order.customer;
                this.orderStatus = order.orderStatus;
                return this;
            }




            public za.ac.cput.domain.Order build() {
                return new za.ac.cput.domain.Order(this);
            }
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(createDate, order.createDate) && Objects.equals(time, order.time) && Objects.equals(customer, order.customer) && orderStatus == order.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, createDate, time, customer, orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createDate=" + createDate +
                ", time=" + time +
                ", customer=" + customer +
                ", orderStatus=" + orderStatus +
                '}';
    }
}


