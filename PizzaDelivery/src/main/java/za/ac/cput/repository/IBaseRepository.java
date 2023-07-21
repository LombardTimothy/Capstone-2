package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Base;

import java.util.ArrayList;
/* IBaseRepository.java
 Author: Timothy Lombard (220154856)
 Date: 21st July (last updated) 2023
*/
@Repository
public interface IBaseRepository extends JpaRepository<Base, String> {

}
