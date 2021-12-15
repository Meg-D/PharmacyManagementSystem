package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineDAO extends JpaRepository<Medicine,Integer> {

    public Optional<Medicine> findByName(String medicineName);

    public Optional<Medicine> findByNameAndCost(String medicineName,Double medicineCost);

    @Query("SELECT m from Medicine m WHERE m.quantity_left>0")
    public List<Medicine> findAll();

}
