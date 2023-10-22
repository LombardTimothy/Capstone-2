package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.StagedOrder;
import za.ac.cput.service.StagedOrderService;
import java.util.ArrayList;

//

@RestController
@RequestMapping("/stagedOrder")
public class StagedOrderController {
    @Autowired
    private StagedOrderService stagedOrderService;

    @PostMapping("/create")
    public StagedOrder create(@RequestBody StagedOrder stagedOrder){
        return stagedOrderService.create(stagedOrder);
    }

    @GetMapping("/read/{id}")
    public StagedOrder read(@PathVariable Integer id){
        return stagedOrderService.read(id);
    }

    @PostMapping("/update")
    public StagedOrder update(@RequestBody StagedOrder stagedOrder){
        return stagedOrderService.update(stagedOrder);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return stagedOrderService.delete(id);
    }

    @GetMapping({"/getall"})
    public ArrayList<StagedOrder> getAll(){
        return stagedOrderService.getAll();
    }
}
