package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;

/*
    AddressRepository.java
    Author: Tamryn Lisa Lewin (219211981)
    Date: 05 April 2023
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

}
