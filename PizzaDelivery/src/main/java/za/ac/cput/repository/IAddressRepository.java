package za.ac.cput.repository;

import za.ac.cput.domain.Address;
import java.util.Set;

/*
IAddressRepository.java
Author: Tamryn Lisa Lewin (219211981)
Date: 05 April 2023
 */

public interface IAddressRepository extends IRepository<Address, String> {
    Address create(Address address);
    Address read(String addressId);
    Address update(Address address);
    boolean delete(String addressId);

    Set<Address> getAll();
}
