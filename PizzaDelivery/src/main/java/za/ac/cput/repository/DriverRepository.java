package za.ac.cput.repository;
/*
DriverRepository.java
Author: Azhar Allie Mohammed (217250513)
Date: 08/04/2023
*/

import za.ac.cput.domain.Driver;

import java.util.HashSet;
import java.util.Set;

public class DriverRepository implements IDriverRepository {
    private static DriverRepository repository = null;
    private  Set<Driver> driverDB = null;

    private DriverRepository(){
        driverDB = new HashSet<Driver>();
    }

    public static DriverRepository getRepository(){
        if(repository == null)
            repository = new DriverRepository();
        return repository;
    }

    @Override
    public Driver create(Driver driver) {
        boolean success = driverDB.add(driver);
        if(!success)
        return null;
        return driver;
    }

    @Override
    public Driver read(String driverId) {
        for(Driver d : driverDB){
            if(d.getDriverId().equals(driverId))
                return d;
        }
        return null;
    }

    @Override
    public Driver update(Driver driver) {
        Driver oldDriver = read(driver.getDriverId());
        if(oldDriver != null){
            driverDB.remove(oldDriver);
            driverDB.add(driver);
            return driver;
        }
        return null;
    }

    @Override
    public boolean delete(String driverId) {
        Driver driverDelete = read(driverId);
        if (driverDelete == null)
        return false;
        driverDB.remove(driverDelete);
        return true;
    }
    @Override
    public Set<Driver> getAll() {
        return driverDB;
    }
}
