package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Driver;
import za.ac.cput.repository.DriverRepository;
import za.ac.cput.service.DriverService;

import java.util.Set;

/*
Author: Azhar Allie Mohammed(217250513)
Date: 11/06/2023
DriverServiceImpl.java
 */
@Service
public class DriverServiceImpl implements DriverService {
    private static DriverServiceImpl service = null;
    private DriverRepository repository = null;
    private DriverServiceImpl(){repository = DriverRepository.getRepository();}

    public static DriverServiceImpl getService(){
        if(service==null){
            service= new DriverServiceImpl();
        }
        return service;
    }


    @Override
    public Driver create(Driver driver) {
        Driver createdDriver = repository.create(driver);
        return createdDriver;
    }

    @Override
    public Driver read(String driverId) {
        Driver readDriver = repository.read(driverId);
        return readDriver;    }

    @Override
    public Driver update(Driver driver) {
        Driver updatedDriver = repository.update(driver);
        return updatedDriver;
    }
    @Override
    public boolean delete(String driverId){
        boolean deleteDriver = repository.delete(driverId);
        return deleteDriver;
    }

    @Override
    public Set<Driver> getAll() {
        return repository.getAll();
    }
}
