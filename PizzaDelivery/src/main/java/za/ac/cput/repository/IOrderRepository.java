package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Order;

/* IOrderRepository.java
 Author: Timothy Lombard (220154856)
 Date: 30th July (last updated) 2023
*/

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {

}

