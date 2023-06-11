package za.ac.cput.service;

import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;

import java.util.Set;

/*VehicleService.java
Author: Azhar Allie Mohammed(217250513)
Date: 11/06/2023

 */
public interface VehicleService extends IService<Vehicle, String>{
    Vehicle create(Vehicle vehicle);
    Vehicle read(String vehicleId);
    Vehicle update(Vehicle vehicle);

    boolean delete(String vehicleId);

    Set<Vehicle> getAll();

}
