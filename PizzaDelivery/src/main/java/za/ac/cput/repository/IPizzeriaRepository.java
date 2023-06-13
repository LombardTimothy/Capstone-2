package za.ac.cput.repository;


import java.util.Set;

import za.ac.cput.domain.Pizzeria;

public interface IPizzeriaRepository extends IRepository<Pizzeria, String> {
    public Set<Pizzeria> getAll();
}
