package za.ac.cput.service;

import za.ac.cput.domain.Driver;

import java.util.Set;

/*DriverService.java
Author: Azhar Allie Mohammed(217250513)
Date: 11/06/2023

 */
public interface DriverService extends IService<Driver, String>{
    Driver create(Driver driver);
    Driver read(String driverId);
    Driver update(Driver driver);

    boolean delete(String driverId);

    Set<Driver> getAll();

}
