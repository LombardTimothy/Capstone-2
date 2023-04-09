package za.ac.cput.domain;

import java.util.Objects;


/* Restaurant.java
   Entity for the Customer
   Author: Keenan Meyer (220194920)
   Date: 30th March 2023
*/
public class Customer {
    private String customerID;
    private String customerName;
    private String customerSurname;
    private Address address;


    private Customer(){

    }

    private Customer(Builder builder){
        this.customerID = builder.customerID;
        this.customerName = builder.customerName;
        this.customerSurname = builder.customerSurname;
        this.address = builder.address;

    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public Address getAddress() {
        return address;
    }


    public static class Builder {
        private String customerID;
        private String customerName;
        private String customerSurname;
        private Address address;

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setCustomerSurname(String customerSurname) {
            this.customerSurname = customerSurname;
            return this;
        }

        public Builder setAddress(Address address){
            this.address = address;
            return this;
        }

        public Builder copy(za.ac.cput.domain.Customer t) {
            this.customerID = t.customerID;
            this.customerName = t.customerName;
            this.customerSurname = t.customerSurname;
            this.address = t.address;
            return this;
        }
        public za.ac.cput.domain.Customer build() {
            return new za.ac.cput.domain.Customer(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerID, customer.customerID) && Objects.equals(customerName, customer.customerName) && Objects.equals(customerSurname, customer.customerSurname) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, customerName, customerSurname, address);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", address=" + address +
                '}';
    }
}
