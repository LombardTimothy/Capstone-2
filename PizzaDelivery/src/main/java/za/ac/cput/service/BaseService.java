package za.ac.cput.service;

import za.ac.cput.domain.Base;

import java.util.ArrayList;

/* BaseService.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/

public interface BaseService extends IService<Base, Integer>{

    Base update(Base base);
    boolean delete(Integer baseId);
    public ArrayList<Base> getAll();
}
