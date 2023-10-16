package za.ac.cput.service;


import za.ac.cput.domain.StagedOrder;

import java.util.ArrayList;

public interface StagedOrderService extends IService<StagedOrder, Integer>{

        StagedOrder create(StagedOrder order);

        StagedOrder read(Integer orderId);

        StagedOrder update(StagedOrder order);

        boolean delete(Integer orderId);

        public ArrayList<StagedOrder> getAll();
}

