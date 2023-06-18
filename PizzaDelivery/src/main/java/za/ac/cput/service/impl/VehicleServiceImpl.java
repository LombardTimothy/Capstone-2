package za.ac.cput.service.impl;
/* VehicleServiceImpl.java
Author: Azhar Allie Mohammed(217250513)
Date: 11/06/2023
 */

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.repository.VehicleRepository;
import za.ac.cput.service.VehicleService;

import java.util.Set;

@Service
public class VehicleServiceImpl implements VehicleService {
    private static VehicleServiceImpl service = null;
    private VehicleRepository repository = null;
    private  VehicleServiceImpl(){repository = VehicleRepository.getRepository();}

    public static VehicleServiceImpl getService(){
        if(service==null){
            service= new VehicleServiceImpl();
        }
        return service;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        Vehicle createVehicle = repository.create(vehicle);
        return createVehicle;
    }

    @Override
    public Vehicle read(String vehicleId) {
        Vehicle readVehicle = repository.read(vehicleId);
        return readVehicle;
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        Vehicle updatedVehicle = repository.update(vehicle);
        return updatedVehicle;
    }

    @Override
    public boolean delete(String vehicleId) {
        boolean deleteVehicle = repository.delete(vehicleId);
        return deleteVehicle;
    }

    @Override
    public Set<Vehicle> getAll() {
        return repository.getAll();
    }
}
