package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.LoyaltyCustomer;

import java.util.Set;

/*
ILoyaltyCustomerRepository.java
Author: Vuyisa Lutho Mqoboli (219191018)
Date: 01 August 2023
Last update: 08 August 2023
 */
@Repository
public interface ILoyaltyCustomerRepository extends JpaRepository<LoyaltyCustomer, String> {

}



