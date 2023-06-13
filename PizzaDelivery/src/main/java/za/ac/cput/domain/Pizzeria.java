package za.ac.cput.domain;

import java.util.Objects;

/* Pizzeria.java
   Entity for the Pizzeria
   Author: Keenan Meyer (220194920)
   Date: 30th March 2023
*/
public class Pizzeria {
    private String restaurantID;
    private String restaurantName;
    private int noOfEmp;
    private Boolean isOpen;

    private Pizzeria(){

    }
    private Pizzeria(Builder builder){
        this.restaurantID = builder.restaurantID;
        this.restaurantName = builder.restaurantName;
        this.noOfEmp = builder.noOfEmp;
        this.isOpen = builder.isOpen;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public int getNoOfEmp() {
        return noOfEmp;
    }

    public Boolean getOpen() {
        return isOpen;
    }



    public static class Builder {
        private String restaurantID;
        private String restaurantName;
        private int noOfEmp;
        private Boolean isOpen;

        public Builder setRestaurantID(String restaurantID) {
            this.restaurantID = restaurantID;
            return this;
        }
        public Builder setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
            return this;
        }
        public Builder setNoOfEmp(int noOfEmp) {
            this.noOfEmp = noOfEmp;
            return this;
        }
        public Builder setIsOpen(Boolean isOpen) {
            this.isOpen = isOpen;
            return this;
        }

        /*public RestaurantBuilder(String restaurantID, String restaurantName, int noOfEmp,Boolean isOpen) {
            this.restaurantID = restaurantID;
            this.restaurantName = restaurantName;
            this.noOfEmp = noOfEmp;
            this.isOpen = isOpen;
        }*/
        public Builder copy(Pizzeria t) {
            this.restaurantID = t.restaurantID;
            this.restaurantName = t.restaurantName;
            this.noOfEmp = t.noOfEmp;
            this.isOpen = t.isOpen;
            return this;
        }

        public Pizzeria build(){
            return new Pizzeria(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizzeria that = (Pizzeria) o;
        return noOfEmp == that.noOfEmp && Objects.equals(restaurantID, that.restaurantID) && Objects.equals(restaurantName, that.restaurantName) && Objects.equals(isOpen, that.isOpen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantID, restaurantName, noOfEmp, isOpen);
    }

    @Override
    public String toString() {
        return "Pizzeria{" +
                "restaurantID='" + restaurantID + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", noOfEmp=" + noOfEmp +
                ", isOpen=" + isOpen +
                '}';
    }
}
