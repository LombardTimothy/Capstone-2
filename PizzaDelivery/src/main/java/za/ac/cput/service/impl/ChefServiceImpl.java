package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Chef;
import za.ac.cput.repository.IChefRepository;
import za.ac.cput.service.ChefService;

import java.util.Set;

/* ChefServiceImpl.java
 Author: Dawood Kamalie (220147760)
 Date: 11th June (last updated) 2023
*/
@Service
public class ChefServiceImpl implements ChefService {
    private IChefRepository chefRepo;
    @Autowired
    private ChefServiceImpl(IChefRepository chefRepo) {
        this.chefRepo = chefRepo;
    }



    @Override
    public Chef create(Chef chef) {
        return this.chefRepo.save(chef);
    }

    @Override
    public Chef read(String chefId) {
        return this.chefRepo.findById(chefId).orElse(null);
    }

    @Override
    public Chef update(Chef chef) {
        if(this.chefRepo.existsById(chef.getChefId())){
            return this.chefRepo.save(chef);
        }else {
            return null;
        }
    }

    @Override
    public boolean delete(String chefId) {
        if(this.chefRepo.existsById(chefId)){
            this.chefRepo.deleteById(chefId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Chef> getAll() {
        return (Set<Chef>) this.chefRepo.findAll();
    }
}

