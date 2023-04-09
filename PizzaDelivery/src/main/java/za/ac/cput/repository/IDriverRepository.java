package za.ac.cput.repository;
/*
IDriverRepository.java
Author: Azhar Allie Mohammed (217250513)
Date: 08/04/2023
*/

import za.ac.cput.domain.Driver;

import java.util.Set;

public interface IDriverRepository extends IRepository<Driver, String> {

    public Set<Driver> getAll();
}
