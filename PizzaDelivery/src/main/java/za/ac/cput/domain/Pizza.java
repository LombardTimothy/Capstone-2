package za.ac.cput.domain;

import java.util.Objects;

/* Pizza.java
 Entity for the Pizza
 Author: Timothy Lombard (220154856)
 Date: 5th April (last updated) 2023
*/

    public class Pizza {

        public enum Size{
            EXTRA_SMALL, SMALL, MEDIUM, LARGE, EXTRA_LARGE
        }
        private String pizzaId;
        private String baseId;
        private String itemName;
        private String itemDescription;
        private Size size;
        private boolean vegetarianOrNot;

        private double price;

        private Pizza(){

        }

        private Pizza(Builder builder){
            this.pizzaId = builder.pizzaId;
            this.baseId = builder.baseId;
            this.itemName = builder.itemName;
            this.itemDescription = builder.itemDescription;
            this.size = builder.size;
            this.vegetarianOrNot = builder.vegetarianOrNot;
            this.price = builder.price;
        }

        public String getPizzaId() {
            return pizzaId;
        }

        public String getBaseId() {
            return baseId;
        }

        public String getItemName() {
            return itemName;
        }

        public String getItemDescription() {
            return itemDescription;
        }

        public Size getSize() {
            return size;
        }

        public boolean isVegetarianOrNot(){return vegetarianOrNot;}

        public double getPrice() {
            return price;
        }

        public static class Builder {
            private String pizzaId;
            private String baseId;
            private String itemName;
            private String itemDescription;
            private Size size;
            private boolean vegetarianOrNot;
            private double price;


            public Builder setPizzaId(String pizzaId) {
                this.pizzaId = pizzaId;
                return this;
            }

            public Builder setBaseId(String baseId) {
                this.baseId = baseId;
                return this;
            }

            public Builder setItemName(String itemName) {
                this.itemName = itemName;
                return this;
            }

            public Builder setItemDescription(String itemDescription){
                this.itemDescription = itemDescription;
                return this;
            }

            public Builder setSize(Size size) {
                this.size = size;
                return this;
            }
            public Builder setVegetarianOrNot(boolean vegetarianOrNot) {
                this.vegetarianOrNot = vegetarianOrNot;
                return this;
            }

            public Builder setPrice(double price) {
                this.price = price;
                return this;
            }


            public Builder copy(za.ac.cput.domain.Pizza menu) {
                this.pizzaId = menu.pizzaId;
                this.baseId = menu.baseId;
                this.itemName = menu.itemName;
                this.itemDescription = menu.itemDescription;
                this.size = menu.size;
                this.vegetarianOrNot = menu.vegetarianOrNot;
                this.price = menu.price;
                return this;
            }


            public za.ac.cput.domain.Pizza build() {
                return new za.ac.cput.domain.Pizza(this);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pizza pizza = (Pizza) o;
            return vegetarianOrNot == pizza.vegetarianOrNot && Double.compare(pizza.price, price) == 0 && Objects.equals(pizzaId, pizza.pizzaId) && Objects.equals(baseId, pizza.baseId) && Objects.equals(itemName, pizza.itemName) && Objects.equals(itemDescription, pizza.itemDescription) && size == pizza.size;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pizzaId, baseId, itemName, itemDescription, size, vegetarianOrNot, price);
        }

        @Override
        public String toString() {
            return "Pizza{" +
                    "pizzaId='" + pizzaId + '\'' +
                    ", baseId='" + baseId + '\'' +
                    ", itemName='" + itemName + '\'' +
                    ", itemDescription='" + itemDescription + '\'' +
                    ", size=" + size +
                    ", vegetarianOrNot=" + vegetarianOrNot +
                    ", price=" + price +
                    '}';
        }
    }


