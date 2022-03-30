package com.revature.controllers;

import com.revature.models.Customer;
import com.revature.services.CustomerMockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-app")
public class CustomerController {

    @Autowired
    CustomerMockService customerMockService;

    @GetMapping("/customers")
    public List<Customer> getCustomerHandler(@RequestParam(required = false, value = "name") String nameParam){
        System.out.println("Name Parameter: " + nameParam);
        if(nameParam==null){ // GET /customers
            return customerMockService.getAllCustomers();
        } else { // GET /customers?name=...
            return customerMockService.getCustomersByName(nameParam);
        }
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable("id")int idParam) {
        return customerMockService.getCustomerById(idParam);
    }

    @PostMapping("/customers")
    public String addNewCustomer(@RequestBody Customer newCustomer){
        System.out.println("We got a customer object:  "+newCustomer);
        customerMockService.addNewCustomer(newCustomer);
        return "you added a new customer named "+ newCustomer.getName();
    }

}
