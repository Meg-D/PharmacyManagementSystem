package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Customer;
import com.iiitb.pharmacy.beans.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SaleDAO extends JpaRepository<Sale,Integer> {
    @Query("SELECT s FROM Sale s WHERE s.cust_id= :customer_id")
    Optional<List<Sale>> findByCustomer(@Param("customer_id")Customer c);


}
