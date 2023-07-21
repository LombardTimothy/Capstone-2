package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.PizzaTopping;
import za.ac.cput.domain.PizzaToppingId;

import java.util.Set;
/* IPizzaToppingRepository.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
@Repository
public interface IPizzaToppingRepository extends JpaRepository<PizzaTopping, PizzaToppingId> {

}
