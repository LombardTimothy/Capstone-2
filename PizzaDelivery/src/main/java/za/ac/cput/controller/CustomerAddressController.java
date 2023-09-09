package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerAddress;
import za.ac.cput.service.CustomerAddressService;

import java.util.ArrayList;

@RestController
@RequestMapping("/customeraddress")
public class CustomerAddressController {

    @Autowired
    private CustomerAddressService customerAddressService;

    @PostMapping("/create")
    public CustomerAddress create(@RequestBody CustomerAddress customerAddress) {
        return customerAddressService.create(customerAddress);
    }

    @GetMapping("/read/{customerID}/{addressId}")
    public ArrayList<CustomerAddress> read(@PathVariable Customer customerID, Address addressId) {
        return customerAddressService.readCustomerIDAndAddressId(customerID, addressId);
    }

    @GetMapping({"/getall"})
    public ArrayList<CustomerAddress> getAll(){
        return customerAddressService.getAll();
    }

}
