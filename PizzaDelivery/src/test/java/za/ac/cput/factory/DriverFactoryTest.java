package za.ac.cput.factory;
/*
DriverFactoryTest.java
Author: Azhar Allie Mohammed (217250513)
Date: 04/04/2023
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class DriverFactoryTest {

    private static Vehicle vehicle = VehicleFactory.createVehicle("Honda", "Honda Accord", "Honda Accord Touring", "2021", "Black");
    @Test
    public void test(){
        Driver driver = DriverFactory.createDriver("Bobby", "Benson", "064-223-6145", "BB@gmail.com", vehicle);
        assertNotNull(driver);
        System.out.println(driver);
    }

}