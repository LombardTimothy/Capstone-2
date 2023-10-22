package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Bill;

/*
    IBillRepository.java
    Author: Vuyisa Lutho Mqoboli (219191018)
    Date: 01 August 2023
    Last update: 08 August 2023
 */

@Repository
public interface IBillRepository extends JpaRepository<Bill, String> {

}

