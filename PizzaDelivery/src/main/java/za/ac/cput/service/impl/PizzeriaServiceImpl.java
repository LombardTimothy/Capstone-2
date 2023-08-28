package za.ac.cput.service.impl;

import java.util.Set;
import java.util.stream.Collectors;

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
    public Set<Pizzeria> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
