package za.ac.cput.factory;
/*
DriverFactory.java
Author: Azhar Allie Mohammed (217250513)
Date: 04/04/2023
*/

import za.ac.cput.domain.Driver;
import za.ac.cput.util.Helper;

public class DriverFactory {
    public static Driver createDriver(String driverId, String empId, String driverName,String driverSurname){
        String driverID = Helper.generateId();

        Driver drv = new Driver.Builder().setDriverId(driverId).setEmpId(empId).setDriverName(driverName).setDriverSurname(driverSurname).build();
        return drv;
    }

    }

