package za.ac.cput.factory;
/*
DriverFactory.java
Author: Azhar Allie Mohammed (217250513)
Date: 04/04/2023
*/

import za.ac.cput.domain.Driver;
import za.ac.cput.util.Helper;

public class DriverFactory {
    public static Driver createDriver(){
        String driverID = Helper.generateId();

        Driver drv = new Driver.Builder().setDriverId(driverID).build();
        return drv;
    }

    }

