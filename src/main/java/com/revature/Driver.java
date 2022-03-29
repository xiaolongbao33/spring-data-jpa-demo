package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@ComponentScan -> com.revature
public class Driver {

    // http://localhost:8080/context-path/serlvet-mapping
    // http://localhost:8080/mapping

    public static void main(String[] args) {
        SpringApplication.run(Driver.class, args);
    }

}
