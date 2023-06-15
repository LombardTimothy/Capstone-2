package za.ac.cput.service.impl;

import za.ac.cput.domain.Base;
import za.ac.cput.repository.BaseRepository;
import za.ac.cput.service.BaseService;

import java.util.ArrayList;
/* BaseServiceImpl.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
public class BaseServiceImpl implements BaseService {

    private static BaseServiceImpl baseService = null;
    private static BaseRepository baseRepo = null;
    private BaseServiceImpl(){
        baseRepo = BaseRepository.getBaseRepo();
    }

    public static BaseServiceImpl getRepo(){//singleton, having access to the private constructor
        if(baseService == null){
            baseService = new BaseServiceImpl();
        }
        return baseService;
    }

    @Override
    public Base create(Base base) {
        Base created = baseRepo.create(base);
        return created;
    }

    @Override
    public Base read(String baseId) {
        Base readBase = baseRepo.read(baseId);
        return readBase;
    }

    @Override
    public Base update(Base base) {
        Base updateBase = baseRepo.update(base);
        return updateBase;
    }

    @Override
    public boolean delete(String baseId) {
       boolean success = baseRepo.delete(baseId);
       return success;
    }

    @Override
    public ArrayList<Base> getAll(){return baseRepo.getAll();}
}
