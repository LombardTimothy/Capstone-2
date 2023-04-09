package za.ac.cput.repository;
/*
IVehicleRepository.java
Author: Azhar Allie Mohammed (217250513)
Date: 08/04/2023
*/

import com.sun.source.doctree.SeeTree;
import za.ac.cput.domain.Vehicle;

import java.util.Set;

public interface IVehicleRepository extends IRepository<Vehicle, String>{
    public Set<Vehicle> getAll();
}
