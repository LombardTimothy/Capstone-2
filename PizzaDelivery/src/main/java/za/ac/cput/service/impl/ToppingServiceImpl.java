package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Topping;
import za.ac.cput.repository.ToppingRepository;
import za.ac.cput.service.ToppingService;

import java.util.ArrayList;
/* ToppingServiceImpl.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
@Service
public class ToppingServiceImpl implements ToppingService {

    private static ToppingServiceImpl toppingService = null;
    private static ToppingRepository toppingRepo = null;
    private ToppingServiceImpl(){
        toppingRepo = ToppingRepository.getToppingRepo();
    }

    public static ToppingServiceImpl getToppingService(){//singleton, having access to the private constructor
        if(toppingService == null){
            toppingService = new ToppingServiceImpl();
        }
        return toppingService;
    }

    @Override
    public Topping create(Topping topping) {
        Topping created = toppingRepo.create(topping);
        return created;
    }

    @Override
    public Topping read(String toppingId) {
        Topping readTopping = toppingRepo.read(toppingId);
        return readTopping;
    }

    @Override
    public Topping update(Topping topping) {
        Topping updateTopping = toppingRepo.update(topping);
        return updateTopping;
    }

    @Override
    public boolean delete(String toppingId) {
        boolean success = toppingRepo.delete(toppingId);
        return success;
    }

    @Override
    public ArrayList<Topping> getAll(){return toppingRepo.getAll();}
}
