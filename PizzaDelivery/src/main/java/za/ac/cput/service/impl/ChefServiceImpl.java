package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Chef;
import za.ac.cput.repository.ChefRepository;
import za.ac.cput.service.ChefService;

import java.util.Set;

/* ChefServiceImpl.java
 Author: Dawood Kamalie (220147760)
 Date: 11th June (last updated) 2023
*/
@Service
public class ChefServiceImpl implements ChefService {
    private static ChefServiceImpl service = null;
    private static ChefRepository repository = null;
    private ChefServiceImpl() {
        repository = ChefRepository.getRepository();
    }
    public static ChefServiceImpl getService(){
        if(service == null) {
            service = new ChefServiceImpl();
        }
        return service;
    }


    @Override
    public Chef create(Chef chef) {
        Chef createdChef = repository.create(chef);
        return createdChef;
    }

    @Override
    public Chef read(String chefId) {
        Chef readChef = repository.read(chefId);
        return readChef;
    }

    @Override
    public Chef update(Chef chef) {
        Chef updatedChef = repository.update(chef);
        return updatedChef;
    }

    @Override
    public boolean delete(String chefId) {
        boolean deletedChef = repository.delete(chefId);
        return deletedChef;
    }

    @Override
    public Set<Chef> getAll() {
        return repository.getAll();
    }
}

