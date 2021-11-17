package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByPhone(String number);

}
