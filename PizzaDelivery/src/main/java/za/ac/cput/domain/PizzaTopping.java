package za.ac.cput.domain;

import java.util.Objects;

/* PizzaTopping.java
 Entity for the PizzaTopping
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/

public class PizzaTopping {

    private String pizzaId;
    private String toppingId;

    private PizzaTopping(){

    }

    private PizzaTopping(Builder builder){
        this.pizzaId = builder.pizzaId;
        this.toppingId = builder.toppingId;
    }

    public String getPizzaId() {
        return pizzaId;
    }

    public String getToppingId() {
        return toppingId;
    }

    public static class Builder{
        private String pizzaId;
        private String toppingId;

        public Builder setPizzaId(String pizzaId) {
            this.pizzaId = pizzaId;
            return this;
        }

        public Builder setToppingId(String toppingId) {
            this.toppingId = toppingId;
            return this;
        }

        public Builder copy(PizzaTopping pt){
            this.pizzaId = pt.pizzaId;
            this.toppingId = pt.toppingId;
            return this;
        }

        public PizzaTopping build(){
            return new PizzaTopping(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaTopping that = (PizzaTopping) o;
        return Objects.equals(pizzaId, that.pizzaId) && Objects.equals(toppingId, that.toppingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizzaId, toppingId);
    }

    @Override
    public String toString() {
        return "PizzaTopping{" +
                "pizzaId=" + pizzaId +
                ", toppingId=" + toppingId +
                '}';
    }
}
