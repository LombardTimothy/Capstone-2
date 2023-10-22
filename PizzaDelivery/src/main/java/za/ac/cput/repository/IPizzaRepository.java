package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Pizza;

/* IPizzaRepository.java
 Author: Timothy Lombard (220154856)
 Date: 21st July (last updated) 2023
*/

@Repository
public interface IPizzaRepository extends JpaRepository<Pizza, Integer> {

}


