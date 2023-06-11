package za.ac.cput.domain;
/*
Driver.java
Author: Azhar Allie Mohammed (217250513)
Date: 04/04/2023
*/
import java.util.Objects;

public class Driver extends Employee{
    private String driverId;
    private String empId = super.getEmpId();
    private  String driverName = super.getEmpName();
    private String driverSurname = super.getEmpSurname();

    public Driver() {
    }

    private Driver(Builder builder){
        this.driverId = builder.driverId;
        this.empId = builder.empId;
        this.driverName = builder.driverName;
        this.driverSurname = builder.driverSurname;
    }

    public String getDriverId() {
        return driverId;
    }

    @Override
    public String getEmpId() {
        return empId;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverSurname() {
        return driverSurname;
    }

    public static class Builder{
        private String driverId;
        private String empId;
        private String driverName;
        private  String driverSurname;

        public Builder setDriverId(String driverId) {
            this.driverId = driverId;
            return this;
        }

        public Builder setEmpId(String empId) {
            this.empId = empId;
            return this;
        }

        public Builder setDriverName(String driverName) {
            this.driverName = driverName;
            return this;
        }

        public Builder setDriverSurname(String driverSurname) {
            this.driverSurname = driverSurname;
            return this;
        }

        public Builder copy(Driver d){
            this.driverId = d.driverId;
            this.empId = d.empId;
            this.driverName = d.driverName;
            this.driverSurname = d.driverSurname;
            return this;
        }

        public Driver build(){return new Driver(this);}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(driverId, builder.driverId) && Objects.equals(empId, builder.empId) && Objects.equals(driverName, builder.driverName) && Objects.equals(driverSurname, builder.driverSurname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(driverId, empId, driverName, driverSurname);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "driverId='" + driverId + '\'' +
                    ", empId='" + empId + '\'' +
                    ", driverName='" + driverName + '\'' +
                    ", driverSurname='" + driverSurname + '\'' +
                    '}';
        }
    }
}
