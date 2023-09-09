package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.*;
import za.ac.cput.service.*;

import java.util.ArrayList;
import java.util.Set;

/*
ApiController.java
Author: Timothy Lombard (220154856)
 Date: 1st September (last updated) 2023
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ChefService chefService;

    @Autowired
    DriverService driverService;

    @Autowired
    VehicleService vehicleService;
    @Autowired
    AddressService addressService;

    @Autowired
    BaseService baseService;
    @Autowired
    BillService billService;

    @Autowired
    CustomerService customerService;

    @Autowired
    LoyaltyCustomerService loyaltyCustomerService;

    @Autowired
    OrderService orderService;
    @Autowired
    OrderLineService orderLineService;
    @Autowired
    PizzaService pizzaService;
    @Autowired
    PizzaToppingService pizzaToppingService;
    @Autowired
    PizzeriaService pizzeriaService;
    @Autowired
    ToppingService toppingService;



    @GetMapping("/api/ping")//connection
    public String ping() {
        System.out.println("Received ping request");
        return "pong";
    }

    @GetMapping("/getAllEmployees")//getAllEmployees
    public ResponseEntity<Set<Employee>> getAllEmployees() {
        Set<Employee> employee = employeeService.getAll();
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/getAllChefs")//getAllChefs
    public ResponseEntity<Set<Chef>> getAllChefs() {
        Set<Chef> chef = chefService.getAll();
        return ResponseEntity.ok(chef);
    }

    @GetMapping("/getAllDrivers")//getAllDrivers
    public ResponseEntity<Set<Driver>> getAllDrivers() {
        Set<Driver> driver = driverService.getAll();
        return ResponseEntity.ok(driver);
    }

    @GetMapping("/getAllVehicles")//getAllVehicles
    public ResponseEntity<Set<Vehicle>> getAllVehicles() {
        Set<Vehicle> vehicle = vehicleService.getAll();
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping("/getAllAddresses")//getAllAddresses
    public ResponseEntity<Set<Address>> getAllAddresses() {
        Set<Address> address = addressService.getAll();
        return ResponseEntity.ok(address);
    }

    @GetMapping("/getAllBases")//getAllBases
    public ResponseEntity<ArrayList<Base>> getAllBases() {
        ArrayList<Base> base = baseService.getAll();
        return ResponseEntity.ok(base);
    }

    @GetMapping("/getAllBills")//getAllBills
    public ResponseEntity<Set<Bill>> getAllBills() {
        Set<Bill> bill = billService.getAll();
        return ResponseEntity.ok(bill);
    }

    @GetMapping("/getAllCustomers")//getAllCustomers
    public ResponseEntity<Set<Customer>> getAllCustomers() {
        Set<Customer> customer = customerService.getAll();
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/getAllLoyaltyCustomers")//getAllLoyaltyCustomers
    public ResponseEntity<Set<LoyaltyCustomer>> getAllLoyaltyCustomers() {
        Set<LoyaltyCustomer> loyaltyCustomer = loyaltyCustomerService.getAll();
        return ResponseEntity.ok(loyaltyCustomer);
    }

    @GetMapping("/getAllOrders")//getAllOrders
    public ResponseEntity<ArrayList<Order>> getAllOrders() {
        ArrayList<Order> order = orderService.getAll();
        return ResponseEntity.ok(order);
    }

    @GetMapping("/getAllOrderLines")//getAllOrderLines
    public ResponseEntity<ArrayList<OrderLine>> getAllOrderLines() {
        ArrayList<OrderLine> orderLine = orderLineService.getAll();
        return ResponseEntity.ok(orderLine);
    }

    @GetMapping("/getAllPizzas")//getAllPizzas
    public ResponseEntity<ArrayList<Pizza>> getAllPizzas() {
        ArrayList<Pizza> pizza = pizzaService.getAll();
        return ResponseEntity.ok(pizza);
    }

    @GetMapping("/getAllPizzaToppings")//getAllPizzaToppings
    public ResponseEntity<ArrayList<PizzaTopping>> getAllPizzaToppings() {
        ArrayList<PizzaTopping> pizzaTopping = pizzaToppingService.getAll();
        return ResponseEntity.ok(pizzaTopping);
    }

    @GetMapping("/getAllPizzerias")//getAllPizzerias
    public ResponseEntity<Set<Pizzeria>> getAllPizzerias() {
        Set<Pizzeria> pizzeria = pizzeriaService.getAll();
        return ResponseEntity.ok(pizzeria);
    }

    @GetMapping("/getAllToppings")//getAllToppings
    public ResponseEntity<ArrayList<Topping>> getAllToppings() {
        ArrayList<Topping> toppings = toppingService.getAll();
        return ResponseEntity.ok(toppings);
    }






}
