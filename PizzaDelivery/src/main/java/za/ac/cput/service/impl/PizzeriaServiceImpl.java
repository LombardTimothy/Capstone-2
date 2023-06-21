package za.ac.cput.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Pizzeria;
import za.ac.cput.repository.IPizzeriaRepository;
import za.ac.cput.service.PizzeriaService;

/*
 * PizzeriaServiceImpl.java
 * Service for the Pizzeria Implimentation
 * Author: Keenan Meyer - 220194920
 * Date: 09 June 2023
 */
@Service
public class PizzeriaServiceImpl implements PizzeriaService {
    private IPizzeriaRepository repository;

    private PizzeriaServiceImpl(IPizzeriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pizzeria create(Pizzeria pizzeria) {
        return this.repository.save(pizzeria);
    }

    @Override
    public Pizzeria read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Pizzeria update(Pizzeria employeeNum) {
        if (this.repository.existsById(employeeNum.getRestaurantID())) {
            return this.repository.save(employeeNum);
        }
        return null;
    }
    

    @Override
    public Set<Pizzeria> getAll() {
        //return repository.findAll();
        return null;
    }
}

/*
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
    public Set<Pizzeria> getAll() {
        return repository.getAll();
    }
}

 */


