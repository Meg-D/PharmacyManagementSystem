package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorDAO extends JpaRepository<Vendor,Integer> {}
