package za.ac.cput.repository;
/*
IVehicleRepository.java
Author: Azhar Allie Mohammed (217250513)
Date: 08/04/2023
*/

import com.sun.source.doctree.SeeTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Vehicle;

import java.util.Set;
@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, String> {
}
