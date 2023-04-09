package za.ac.cput.repository;

import za.ac.cput.domain.Bill;

import java.util.Set;

public interface IBillRepository extends IRepository<Bill, String> {
    public Set<Bill> getAll();
}
