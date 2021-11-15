package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleDAO extends JpaRepository<Sale,Integer> {
}
