package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Customer;
import com.iiitb.pharmacy.beans.Sale;
import com.iiitb.pharmacy.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SaleDAO extends JpaRepository<Sale,Integer> {
    @Query("SELECT s FROM Sale s WHERE s.cust_id= :cust_id_customer_id")
    Optional<List<Sale>> findByCustomer(@Param("cust_id_customer_id")Customer customer_id);


    @Query("SELECT s FROM Sale s where s.user_id= :user_id_user_id")
    Optional<List<Sale>> findByUser(@Param("user_id_user_id") User user_id);
}
