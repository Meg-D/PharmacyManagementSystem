package com.iiitb.pharmacy.services;


import com.iiitb.pharmacy.beans.Customer;


public interface CustomerService {

    public Customer addCustomer(Customer customer);
    public Customer getCustomerByContactNumber(String number);
}
