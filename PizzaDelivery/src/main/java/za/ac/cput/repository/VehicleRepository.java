package za.ac.cput.repository;

import za.ac.cput.domain.Vehicle;
import java.util.HashSet;
import java.util.Set;

/*
VehicleRepository.java
Author: Azhar Allie Mohammed (217250513)
Date: 08/04/2023
*/
public class VehicleRepository implements IVehicleRepository{
    private static VehicleRepository repository = null;
    private Set<Vehicle> vehicleDB = null;

    private VehicleRepository(){vehicleDB = new HashSet<Vehicle>();}
    public static VehicleRepository getRepository(){
        if(repository == null)
            repository = new VehicleRepository();
        return repository;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        boolean success = vehicleDB.add(vehicle);
        if(!success)
            return null;
        return vehicle;
    }

    @Override
    public Vehicle read(String vehicleId) {
        for(Vehicle v : vehicleDB){
            if(v.getVehicleId().equals(vehicleId))
                return v;
        }
        return null;
    }

    @Override
    public Vehicle update(Vehicle v) {
        Vehicle oldVehicle = read(v.getVehicleId());
        if(oldVehicle != null){
            vehicleDB.remove(oldVehicle);
            vehicleDB.add(v);
            return v;
        }
        return null;
    }

    @Override
    public boolean delete(String vehicleId) {
        Vehicle vehicleDelete = read(vehicleId);
        if (vehicleDelete == null)
            return false;
        vehicleDB.remove(vehicleDelete);
        return true;
    }
    @Override
    public Set<Vehicle> getAll() {
        return vehicleDB;
    }

}
