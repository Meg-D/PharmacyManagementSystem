package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDAO extends JpaRepository<Transaction,Integer> {
}
