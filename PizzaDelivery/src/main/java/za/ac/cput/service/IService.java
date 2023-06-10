package za.ac.cput.service;
/* IService.java
 Author: Timothy Lombard (220154856)
 Date: 9th June (last updated) 2023
*/
public interface IService <T, ID>{

    T create(T t);
    T read(ID id);
    T update(T t);

}
