package za.ac.cput.service.impl;
/* VehicleServiceImpl.java
Author: Azhar Allie Mohammed(217250513)
Date: 11/06/2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.repository.IVehicleRepository;
import za.ac.cput.service.VehicleService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {
    private IVehicleRepository vehicleRepository;

    @Autowired
    private VehicleServiceImpl(IVehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }



    @Override
    public Vehicle create(Vehicle vehicle) {
        return this.vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle read(String vehicleId) {
        return this.vehicleRepository.findById(vehicleId).orElse(null);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        if(this.vehicleRepository.existsById(vehicle.getVehicleId())){
            return this.vehicleRepository.save(vehicle);
        }else{
            return null;
        }

    }

    @Override
    public boolean delete(String vehicleId) {
        if(this.vehicleRepository.existsById(vehicleId)){
            this.vehicleRepository.deleteById(vehicleId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Vehicle> getAll() {
        return this.vehicleRepository.findAll().stream().collect(Collectors.toSet());
    }
}


