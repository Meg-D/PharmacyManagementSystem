package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Customer;
import com.iiitb.pharmacy.beans.Sale;
import com.iiitb.pharmacy.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SaleDAO extends JpaRepository<Sale,Integer> {
    @Query("SELECT s FROM Sale s WHERE s.cust_id= :customer_id")
    Optional<List<Sale>> findByCustomer(@Param("customer_id")Customer customer_id);


    @Query("SELECT s FROM Sale s where s.user_id= : user_id")
    Optional<List<Sale>> findByUser(@Param("user_id") User user_id);
}
