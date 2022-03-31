package com.revature.repositories;

import com.revature.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// by extending the JpaRepository, we're able to access all of its methods
    // the two generic types that we provide represent the Entity type and its ID
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findCustomerByName(String name);

}
