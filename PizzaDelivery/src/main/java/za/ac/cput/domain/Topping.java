package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
/* Topping.java
 Entity for the Topping
 Author: Timothy Lombard (220154856)
 Date: 21st July (last updated) 2023
*/
@Entity
public class Topping {

    @Id
    private String toppingId;
    private String toppingName;
    private String toppingDescription;
    private int toppingQuantity;
    private double toppingPrice;

    protected Topping(){

    }

    private Topping(Topping.Builder builder){
        this.toppingId = builder.toppingId;
        this.toppingName = builder.toppingName;
        this.toppingDescription = builder.toppingDescription;
        this.toppingQuantity = builder.toppingQuantity;
        this.toppingPrice = builder.toppingPrice;
    }

    public String getToppingId() {
        return toppingId;
    }

    public String getToppingName() {
        return toppingName;
    }

    public String getToppingDescription() {
        return toppingDescription;
    }

    public int getToppingQuantity() {
        return toppingQuantity;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public static class Builder {
        private String toppingId;
        private String toppingName;
        private String toppingDescription;
        private int toppingQuantity;
        private double toppingPrice;


        public Topping.Builder setToppingId(String toppingId) {
            this.toppingId = toppingId;
            return this;
        }

        public Topping.Builder setToppingName(String toppingName){
            this.toppingName = toppingName;
            return this;
        }

        public Topping.Builder setToppingDescription(String toppingDescription){
            this.toppingDescription = toppingDescription;
            return this;
        }

        public Topping.Builder setToppingQuantity(int toppingQuantity){
            this.toppingQuantity = toppingQuantity;
            return this;
        }

        public Topping.Builder setToppingPrice(double toppingPrice){
            this.toppingPrice = toppingPrice;
            return this;
        }

        public Topping.Builder copy(Topping topping) {
            this.toppingId = topping.toppingId;
            this.toppingName = topping.toppingName;
            this.toppingDescription = topping.toppingDescription;
            this.toppingQuantity = topping.toppingQuantity;
            this.toppingPrice = topping.toppingPrice;
            return this;
        }


        public Topping build() {
            return new Topping(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topping topping = (Topping) o;
        return toppingQuantity == topping.toppingQuantity && Double.compare(topping.toppingPrice, toppingPrice) == 0 && Objects.equals(toppingId, topping.toppingId) && Objects.equals(toppingName, topping.toppingName) && Objects.equals(toppingDescription, topping.toppingDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toppingId, toppingName, toppingDescription, toppingQuantity, toppingPrice);
    }

    @Override
    public String toString() {
        return "Topping{" +
                "Topping Id='" + toppingId + '\'' +
                ", Topping name='" + toppingName + '\'' +
                ", Topping description='" + toppingDescription + '\'' +
                ", Topping quantity=" + toppingQuantity +
                ", Topping price= R" + toppingPrice +
                '}';
    }
}
