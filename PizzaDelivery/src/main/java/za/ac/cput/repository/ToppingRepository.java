package za.ac.cput.repository;

import za.ac.cput.domain.Topping;

import java.util.ArrayList;
/* ToppingRepository.java
 Author: Timothy Lombard (220154856)
 Date: 13th June (last updated) 2023
*/
public class ToppingRepository implements IToppingRepository{

    private static ToppingRepository toppingRepo = null;
    private ArrayList<Topping> toppingDB;
    private ToppingRepository(){
        toppingDB = new ArrayList<Topping>();
    }

    public static ToppingRepository getToppingRepo(){//singleton, having access to the private constructor
        if(toppingRepo == null){
            toppingRepo = new ToppingRepository();
        }
        return toppingRepo;
    }

    @Override
    public Topping create(Topping topping) {
        boolean success = toppingDB.add(topping);
        if(!success) {
            return null;
        }else {
            return topping;
        }
    }

    @Override
    public Topping read(String toppingId) {
        for(Topping o : toppingDB){
            if(o.getToppingId().equals(toppingId))
                return o;
        }
        return null;
    }

    @Override
    public Topping update(Topping topping) {
        Topping oldTopping = read(topping.getToppingId());
        if(oldTopping != null){
            toppingDB.remove(oldTopping);
            toppingDB.add(topping);
            return topping;
        }
        return null;
    }

    @Override
    public boolean delete(String toppingId) {
        Topping deleteTopping = read(toppingId);
        if(deleteTopping == null){
            System.out.println("Could not delete");
            return false;
        }
        toppingDB.remove(deleteTopping);
        System.out.println("Could delete");
        return true;
    }

    @Override
    public ArrayList<Topping> getAll(){return toppingDB;}
}
