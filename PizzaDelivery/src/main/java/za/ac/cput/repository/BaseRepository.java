package za.ac.cput.repository;

import za.ac.cput.domain.Base;

import java.util.ArrayList;
/* BaseRepository.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
public class BaseRepository implements IBaseRepository{

    private static BaseRepository baseRepo = null;
    private ArrayList<Base> baseDB;
    private BaseRepository(){
        baseDB = new ArrayList<Base>();
    }

    public static BaseRepository getBaseRepo(){//singleton, having access to the private constructor
        if(baseRepo == null){
            baseRepo = new BaseRepository();
        }
        return baseRepo;
    }

    @Override
    public Base create(Base base) {
        boolean success = baseDB.add(base);
        if(!success) {
            return null;
        }else {
            return base;
        }
    }

    @Override
    public Base read(String baseId) {
        for(Base o : baseDB){
            if(o.getBaseId().equals(baseId))
                return o;
        }
        return null;
    }

    @Override
    public Base update(Base base) {
        Base oldBase = read(base.getBaseId());
        if(oldBase != null){
            baseDB.remove(oldBase);
            baseDB.add(base);
            return base;
        }
        return null;
    }

    @Override
    public boolean delete(String baseId) {
        Base deleteBase = read(baseId);
        if(deleteBase == null){
            System.out.println("Could not delete");
            return false;
        }
        baseDB.remove(deleteBase);
        System.out.println("Could delete");
        return true;
    }

    @Override
    public ArrayList<Base> getAll(){return baseDB;}
}

