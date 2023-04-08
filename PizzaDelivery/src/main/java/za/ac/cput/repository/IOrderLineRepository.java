package za.ac.cput.repository;

import za.ac.cput.domain.OrderLine;
import java.util.ArrayList;

/*
IOrderLineRepository.java
Author: Tamryn Lisa Lewin (219211981)
Date: 05 April 2023
 */

public interface IOrderLineRepository extends IRepository<OrderLine, String> {
    OrderLine create(OrderLine orderLine);

    OrderLine read(String orderLineId);

    OrderLine update(OrderLine orderLine);

    boolean delete(String orderLineId);

    ArrayList<OrderLine> getAll();
}
