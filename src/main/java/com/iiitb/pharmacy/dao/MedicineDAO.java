package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicineDAO extends JpaRepository<Medicine,Integer> {

    public Optional<Medicine> findByName(String medicineName);

//    @Query("SELECT m.amount from Medicine m WHERE m.medicine_id= :med_id")
//    Double getAmountById(@Param(med_id)  Medicine med_id);
}
