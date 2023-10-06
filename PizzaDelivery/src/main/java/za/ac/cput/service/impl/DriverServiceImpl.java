package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Driver;


import za.ac.cput.repository.IDriverRepository;
import za.ac.cput.service.DriverService;

import java.util.Set;
import java.util.stream.Collectors;

/*
Author: Azhar Allie Mohammed(217250513)
Date: 11/06/2023
DriverServiceImpl.java
 */

@Service
public class DriverServiceImpl implements DriverService {
    private IDriverRepository driverRepository;

    @Autowired
    private DriverServiceImpl(IDriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }



    @Override
    public Driver create(Driver driver) {
        return this.driverRepository.save(driver);
    }

    @Override
    public Driver read(String empId) {
        return this.driverRepository.findById(empId).orElse(null);
    }

    @Override
    public Driver update(Driver driver) {
        if(this.driverRepository.existsById(String.valueOf(driver.getEmpId()))){
            return this.driverRepository.save(driver);
        }else{
            return null;
        }

    }

    @Override
    public boolean delete(String empId) {
        if(this.driverRepository.existsById(empId)){
            this.driverRepository.deleteById(empId);
            return true;
        }
        return false;
    }
    @Override
    public Set<Driver> getAll() {
        return this.driverRepository.findAll().stream().collect(Collectors.toSet());
    }
}


