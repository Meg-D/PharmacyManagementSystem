package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Customer;
import com.iiitb.pharmacy.dao.CustomerDAO;
import com.iiitb.pharmacy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public void addCustomer(Customer customer){

    }

    public Customer getCustomerById(String id){
        return new Customer();
    }

}
