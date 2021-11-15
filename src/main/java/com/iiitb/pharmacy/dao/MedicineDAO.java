package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineDAO extends JpaRepository<Medicine,Integer> {
}
