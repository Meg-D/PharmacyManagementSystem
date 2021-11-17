package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.beans.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction,Integer> {
    @Query("SELECT t from Transaction t where t.ven_id= :vendor_id")
    Optional<List<Transaction>> findByVendorId(@Param("vendor_id")Vendor vendor_id);

    @Query("SELECT t from Transaction t where t.user_id= :user_id")
    Optional<List<Transaction>> findByUserId(@Param("user_id") User user_id);
}
