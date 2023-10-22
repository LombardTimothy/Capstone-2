package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Base;
import za.ac.cput.repository.IBaseRepository;
import za.ac.cput.service.BaseService;

import java.util.ArrayList;

/* BaseServiceImpl.java
 Author: Timothy Lombard (220154856)
 Date: 21st July (last updated) 2023
*/

@Service
public class BaseServiceImpl implements BaseService {
    private IBaseRepository baseRepo;
    @Autowired
    private BaseServiceImpl(IBaseRepository baseRepo){
        this.baseRepo = baseRepo;
    }

    @Override
    public Base create(Base base) {
        return this.baseRepo.save(base);
    }

    @Override
    public Base read(Integer id) {
        return this.baseRepo.findById(id).orElse(null);
    }

    @Override
    public Base update(Base base) {
        if(this.baseRepo.existsById(Integer.valueOf(String.valueOf(base.getBaseId())))){
            return this.baseRepo.save(base);
        }else{
            return null;
        }

    }

    @Override
    public boolean delete(Integer id) {
        if(this.baseRepo.existsById(Integer.valueOf(String.valueOf(id)))){
            this.baseRepo.deleteById(Integer.valueOf(String.valueOf(id)));
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Base> getAll(){return (ArrayList<Base>) this.baseRepo.findAll();}
}
