package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineDAO extends JpaRepository<Medicine,Integer> {

    public Optional<Medicine> findByName(String medicineName);

    public Optional<Medicine> findByNameAndCost(String medicineName,Double medicineCost);

   // Optional<Medicine> findByNameandPrice(String medicine_name, Double price);

//    @Query("SELECT m.amount from Medicine m WHERE m.medicine_id= :med_id")
//    Double getAmountById(@Param(med_id)  Medicine med_id);
}
