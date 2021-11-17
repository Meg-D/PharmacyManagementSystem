package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicineDAO extends JpaRepository<Medicine,Integer> {

    public Optional<Medicine> findByName(String medicineName);

}
