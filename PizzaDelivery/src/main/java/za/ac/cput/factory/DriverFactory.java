package za.ac.cput.factory;
/*
DriverFactory.java
Author: Azhar Allie Mohammed (217250513)
Date: 04/04/2023
*/

import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.util.Helper;

public class DriverFactory {
    public static Driver createDriver(String name, String surname, String phoneNumber, String email, Vehicle vehicleId){
        if(Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(surname) || Helper.isNullOrEmpty(phoneNumber) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(String.valueOf(vehicleId))){
            return null;
        }
        String empId = Helper.generateId();

      Driver driver = (Driver) new Driver.Builder().setVehicle(vehicleId).setEmpId(empId).setName(name).setSurname(surname).setPhoneNumber(phoneNumber).setEmail(email).build();
      return driver;
    }

    }

