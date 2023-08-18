package za.ac.cput.repository;
/*
IDriverRepository.java
Author: Azhar Allie Mohammed (217250513)
Date: 08/04/2023
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Driver;

import java.util.Set;
@Repository
public interface IDriverRepository extends JpaRepository<Driver, String> {


}
