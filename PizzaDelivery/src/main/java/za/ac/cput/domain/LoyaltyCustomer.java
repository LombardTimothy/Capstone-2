package za.ac.cput.domain;
import java.time.LocalDate;
import java.util.Objects;

/*
LoyaltyCustomer.java
LoyaltyCustomer entity
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 04 April 2023
 */


public class LoyaltyCustomer {
    private String loyaltyCustomerId;
    private LocalDate dateJoined;
    private double discounts;

    private LoyaltyCustomer(){

    }

    private LoyaltyCustomer(Builder builder){
        this.loyaltyCustomerId = builder.loyaltyCustomerId;
        this.dateJoined = builder.dateJoined;
        this.discounts = builder.discounts;

    }
    public String getLoyaltyCustomerId() {
        return loyaltyCustomerId;
    }
    public LocalDate getDateJoined() {
        return dateJoined;
    }
    public double getDiscounts() {
        return discounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoyaltyCustomer that)) return false;
        return Double.compare(that.discounts, discounts) == 0 && Objects.equals(loyaltyCustomerId, that.loyaltyCustomerId) && Objects.equals(dateJoined, that.dateJoined);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loyaltyCustomerId, dateJoined, discounts);
    }

    @Override
    public String toString() {
        return "LoyaltyCustomer{" +
                "LoyaltyCustomerId='" + loyaltyCustomerId + '\'' +
                ", dateJoined='" + dateJoined + '\'' +
                ", discounts=" + discounts +
                '}';
    }

    public static class Builder{

        private String loyaltyCustomerId;
        private LocalDate dateJoined;
        private double discounts;

        public Builder setLoyaltyCustomerId(String loyaltyCustomerId) {
            this.loyaltyCustomerId = loyaltyCustomerId;
            return this;
        }

        public Builder setDateJoined(LocalDate dateJoined) {
            this.dateJoined = dateJoined;
            return this;
        }

        public Builder setDiscounts(double discounts) {
            this.discounts = discounts;
            return this;
        }


        public Builder copy(LoyaltyCustomer loyaltyCustomer){
            this.loyaltyCustomerId = loyaltyCustomer.loyaltyCustomerId;
            this.dateJoined = loyaltyCustomer.dateJoined;
            this.discounts = loyaltyCustomer.discounts;
            return this;
        }
        public LoyaltyCustomer build(){
            return new LoyaltyCustomer(this);
        }
    }
}

