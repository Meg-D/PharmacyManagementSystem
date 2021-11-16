package com.iiitb.pharmacy.services;


import com.iiitb.pharmacy.beans.Customer;

public interface CustomerService {

    public void addCustomer(Customer customer);
    public Customer getCustomerById(String id);
}
