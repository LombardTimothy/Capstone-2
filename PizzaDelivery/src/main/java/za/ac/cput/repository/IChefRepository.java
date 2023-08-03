package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Chef;

import java.util.Set;

/*
* IChefRepository.java
* Author: Dawood Kamalie  (220147760)
* Date: 8/4/2023
* */

public interface IChefRepository extends JpaRepository<Chef, String> {
     Set<Chef> getAll();
}
