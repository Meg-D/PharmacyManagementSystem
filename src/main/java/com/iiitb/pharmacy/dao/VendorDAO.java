package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorDAO extends JpaRepository<Vendor,Integer> {
}
