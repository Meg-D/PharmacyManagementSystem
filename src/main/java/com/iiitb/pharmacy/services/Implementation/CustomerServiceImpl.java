package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Customer;
import com.iiitb.pharmacy.dao.CustomerDAO;
import com.iiitb.pharmacy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    // register a new customer
    public Customer addCustomer(Customer customer){
        Optional<Customer> obj = customerDAO.findByPhone(customer.getPhone());
        if(obj.isEmpty()) customerDAO.save(customer);
        return customer;
    }


    // return customer corresponding to the given number
    public Customer getCustomerByContactNumber(String number){
        Optional<Customer> obj = customerDAO.findByPhone(number);
        if(obj.isEmpty()) return null;
        return obj.get();
    }

}
