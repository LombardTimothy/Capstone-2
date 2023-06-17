package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Chef;
import za.ac.cput.domain.Employee;

import java.util.Set;

/* ChefService.java
 Author: Dawood Kamalie (220147760)
 Date: 11th June (last updated) 2023
*/
@Service
public interface ChefService extends IService<Chef, String> {
     Chef create(Chef chef);
     Chef read(String chefId);
     Chef update(Chef chef);
     boolean delete(String chefId);
     Set<Chef> getAll();


}
