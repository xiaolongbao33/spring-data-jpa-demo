package com.revature.controllers;

import com.revature.models.Customer;
import com.revature.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/customer-app")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomerHandler(@RequestParam(required = false, value = "name") String nameParam){
        System.out.println("Name Parameter: " + nameParam);
        if(nameParam==null){ // GET /customers
            return customerService.getAllCustomers();
        } else { // GET /customers?name=...
            return customerService.getCustomersByName(nameParam);
        }
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable("id")int idParam) {
        return customerService.getCustomerById(idParam);
    }

    @PostMapping("/customers")
    public Customer addNewCustomer(@RequestBody Customer newCustomer){
        System.out.println("We got a customer object:  "+newCustomer);
        return customerService.addNewCustomer(newCustomer);
    }

}
