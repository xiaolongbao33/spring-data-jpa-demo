package com.revature.services;

import com.revature.models.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerMockService {

    private final List<Customer> customerList = new ArrayList<>();

    public CustomerMockService(){
        customerList.add(new Customer(11,"Lola", "lolajenkins@gmail.com"));
        customerList.add(new Customer(12,"Polly", "polly@gmail.com"));
        customerList.add(new Customer(13,"Jones", "jones3726@gmail.com"));
        customerList.add(new Customer(14,"Lola", "lola28@gmail.com"));
    }

    public List<Customer> getAllCustomers(){
        return customerList;
    }

    public void addNewCustomer(Customer newCustomer){
        int maxId = 0;
        for(Customer customer: customerList){
            if(customer.getId()>0){
                maxId = customer.getId();
            }
        }
        newCustomer.setId(++maxId);
        customerList.add(newCustomer);
    }

    public List<Customer> getCustomersByName(String name){
        List<Customer> filteredCustomers = new ArrayList<>();
        for(Customer c : customerList){
            if(c.getName()!=null && c.getName().equals(name)){
                filteredCustomers.add(c);
            }
        }
        return filteredCustomers;
    }

    public Customer getCustomerById(int id){
        for(Customer c: customerList){
            if(c.getId()==id){
                return c;
            }
        }
        return null;
    }


}
