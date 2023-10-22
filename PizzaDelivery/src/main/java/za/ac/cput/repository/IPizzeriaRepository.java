package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Pizzeria;

@Repository
public interface IPizzeriaRepository extends JpaRepository<Pizzeria, String> {

}
