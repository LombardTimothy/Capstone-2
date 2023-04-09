package za.ac.cput.factory;
/*
VehicleFactory.java
Author: Azhar Allie Mohammed (217250513)
Date: 04/04/2023
*/

import za.ac.cput.domain.Vehicle;
import za.ac.cput.util.Helper;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType){
        if (Helper.isNullOrEmpty(vehicleType)) {
            return null;
        }
       String vehicleID = Helper.generateId();

       // return new Vehicle.Builder().setVehicleId(vehicleId)
         //       .setVehicleType(vehicleType)
           //     .build();

        Vehicle veh = new Vehicle.Builder().setVehicleId(vehicleID).setVehicleType(vehicleType).build();
        return veh;
    }
}
