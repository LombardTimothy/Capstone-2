package za.ac.cput.factory;
/*
VehicleFactory.java
Author: Azhar Allie Mohammed (217250513)
Date: 04/04/2023
*/

import za.ac.cput.domain.Vehicle;
import za.ac.cput.util.Helper;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType, String make, String model, String year, String colour){
        if (Helper.isNullOrEmpty(vehicleType) || Helper.isNullOrEmpty(make) || Helper.isNullOrEmpty(model) || Helper.isNullOrEmpty(year) || Helper.isNullOrEmpty(colour)) {
            return null;
        }
        Integer vehicleId = Helper.generateId2();


        Vehicle vehicle = new Vehicle.Builder().setVehicleId(vehicleId).setVehicleType(vehicleType).setMake(make).setModel(model).setYear(year).setColour(colour).build();
        return vehicle;
    }
}
