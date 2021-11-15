package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer,Integer> {
}
