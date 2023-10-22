package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Driver;

/*
IDriverRepository.java
Author: Azhar Allie Mohammed (217250513)
Date: 08/04/2023
*/

@Repository
public interface IDriverRepository extends JpaRepository<Driver, String> {

}
