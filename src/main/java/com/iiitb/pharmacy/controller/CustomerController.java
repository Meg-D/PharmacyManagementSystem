package com.iiitb.pharmacy.controller;


import com.iiitb.pharmacy.beans.Customer;
import com.iiitb.pharmacy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // register a new customer
    @PostMapping(path = "/add",
    consumes = {"application/json"},
    produces = {"application/json"})
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    // return customer identified via phone number
    @GetMapping("/getCustomer/{phoneNumber}")
    public Customer getCustomerByContactNumber(@PathVariable String phoneNumber){
        return customerService.getCustomerByContactNumber(phoneNumber);
    }


}
