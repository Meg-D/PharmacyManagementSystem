package com.iiitb.pharmacy.controller;


import com.iiitb.pharmacy.beans.Customer;
import com.iiitb.pharmacy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class ServiceController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/add",
    consumes = {"application/json"},
    produces = {"application/json"})
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @GetMapping("/getCustomer/{customerId}")
    public Customer getCustomerById(@PathVariable String customerId){
        return customerService.getCustomerById(customerId);
    }


}
