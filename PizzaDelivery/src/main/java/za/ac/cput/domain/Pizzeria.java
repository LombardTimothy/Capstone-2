package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

/* Pizzeria.java
   Entity for the Pizzeria
   Author: Keenan Meyer (220194920)
   Date: 30th March 2023
*/
@Entity
public class Pizzeria implements Serializable {
    @Id
    private String restaurantID;
    private String restaurantName;
    private String location;

    protected Pizzeria(){

    }
    private Pizzeria(Builder builder){
        this.restaurantID = builder.restaurantID;
        this.restaurantName = builder.restaurantName;
        this.location = builder.location;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getLocation() {
        return location;
    }




    public static class Builder {
        private String restaurantID;
        private String restaurantName;
        private String location;

        public Builder setRestaurantID(String restaurantID) {
            this.restaurantID = restaurantID;
            return this;
        }
        public Builder setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
            return this;
        }
        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder copy(Pizzeria t) {
            this.restaurantID = t.restaurantID;
            this.restaurantName = t.restaurantName;
            this.location = t.location;
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
        Pizzeria pizzeria = (Pizzeria) o;
        return Objects.equals(restaurantID, pizzeria.restaurantID) && Objects.equals(restaurantName, pizzeria.restaurantName) && Objects.equals(location, pizzeria.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantID, restaurantName, location);
    }

    @Override
    public String toString() {
        return "Pizzeria{" +
                "restaurantID='" + restaurantID + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
