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

    // we want to tie the get all customer functionality to GET /customers
    // we can annotate a handler method to that
//    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    @GetMapping("/customers")
//    @ResponseBody
    public List<Customer> getCustomerHandler(@RequestParam(required = false, value = "name") String nameParam){
        System.out.println("Name Parameter: " + nameParam);
        if(nameParam==null){ // GET /customers
            return customerMockService.getAllCustomers();
        } else { // GET /customers?name=...
            return customerMockService.getCustomersByName(nameParam);
        }
    }

    @GetMapping("/customers/{id}")
//    @ResponseBody
    public Customer getCustomerById(@PathVariable("id")int idParam){
        return customerMockService.getCustomerById(idParam);
    }

    /*
    @PostMapping("/customers")
    @ResponseBody
    public String addNewCustomer(@RequestParam("name")String name, @RequestParam("email")String email){
        System.out.println("We got some request params - name = "+name+" and email = "+email);
        // once we have a name and email, we can create a new Customer and add it to the list
        Customer newCustomer = new Customer(name, email);
        customerMockService.addNewCustomer(newCustomer);
        return "you added a new customer named "+ name;
    }*/

    @PostMapping("/customers")
//    @ResponseBody
    // @RequestBody uses jackson to map JSON data in request into a Customer object
    public String addNewCustomer(@RequestBody Customer newCustomer){
        System.out.println("We got a customer object:  "+newCustomer);
        // once we have a name and email, we can create a new Customer and add it to the list
        customerMockService.addNewCustomer(newCustomer);
        return "you added a new customer named "+ newCustomer.getName();
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    @GetMapping("/hello")
//    @ResponseBody // return of the method is written to the HTTP response body
    public String helloWorldHandler(){
        return "Hello World";
    }

}
