package za.ac.cput.repository;

import za.ac.cput.domain.Base;

import java.util.ArrayList;
/* IBaseRepository.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
public interface IBaseRepository extends IRepository<Base, String>{

    Base create(Base base);
    Base read(String baseId);
    Base update(Base base);
    boolean delete(String baseId);
    public ArrayList<Base> getAll();
}
