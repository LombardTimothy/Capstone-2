package za.ac.cput.domain;
/*
Driver.java
Author: Azhar Allie Mohammed (217250513)
Date: 04/04/2023
*/
import java.util.Objects;

public class Driver extends Employee{
    private String driverId;

    public Driver() {
    }

    private Driver(Builder builder){
        this.driverId = builder.driverId;
    }

    public String getDriverId() {
        return driverId;
    }

    public static class Builder{
        private String driverId;

        public Builder setDriverId(String driverId) {
            this.driverId = driverId;
            return this;
        }

        public Builder copy(Driver d){
            this.driverId = d.driverId;
            return this;
        }

        public Driver build(){return new Driver(this);}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(driverId, builder.driverId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(driverId);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "driverId='" + driverId + '\'' +
                    '}';
        }
    }
}
