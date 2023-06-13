package za.ac.cput.service.impl;

import java.util.Set;

import za.ac.cput.domain.Pizzeria;
import za.ac.cput.repository.PizzeriaRepository;
import za.ac.cput.service.PizzeriaService;

/*
 * PizzeriaServiceImpl.java
 * Service for the Pizzeria Implimentation
 * Author: Keenan Meyer - 220194920
 * Date: 09 June 2023
 */
public class PizzeriaServiceImpl implements PizzeriaService {


    private static PizzeriaServiceImpl service = null;
    private static PizzeriaRepository repository = null;

    private PizzeriaServiceImpl() {
        if (repository == null) {
            repository = PizzeriaRepository.getRepository();
        }
    }

    public static PizzeriaServiceImpl getService() {
        if (service == null) {
            service = new PizzeriaServiceImpl();
        }
        return service;
    }


    @Override
    public Pizzeria create(Pizzeria pizzeria) {
        Pizzeria readPizzeria = repository.create(pizzeria);
        return readPizzeria;
    }

    @Override
    public Pizzeria read(String id) {
        Pizzeria read = repository.read(id);
        return read;
    }

    @Override
    public Pizzeria update(Pizzeria employeeNum) {
        Pizzeria updated = repository.update(employeeNum);
        return updated;
    }

    @Override
    public boolean delete(String restaurantNum) {
        boolean success = repository.delete(String.valueOf(restaurantNum));
        return success;
    }

    @Override
    public Set<Pizzeria> getAll() {
        return repository.getAll();
    }
}

