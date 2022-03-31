package com.revature.services;

import com.revature.exceptions.CustomerNotFoundException;
import com.revature.models.Customer;
import com.revature.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;


    public CustomerService(){
    }

    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    public Customer addNewCustomer(Customer newCustomer){
        return repository.save(newCustomer);
    }

    public List<Customer> getCustomersByName(String name){
        return repository.findCustomerByName(name);
    }

    public Customer getCustomerById(int id){
        Optional<Customer> customerOptional = repository.findById(id);
        if(customerOptional.isPresent()){
            return customerOptional.get();
        } else {
            throw new CustomerNotFoundException();
        }
    }


}
