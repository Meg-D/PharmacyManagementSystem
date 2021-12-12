package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.Medicine;
import org.springframework.stereotype.Service;

import java.util.*;

public interface MedicineService {

    public Medicine getMedicineByName(String medicineName);
    public List<Medicine> getAllMedicines();
    public Medicine addMedicine(Medicine medicine);
    public Medicine updateMedicine(Medicine medicine, int quantity);
    public Medicine updateMedicineByTransaction(Medicine medicine,int quantity);
    public Medicine updateMedicineBySale(Medicine medicine,int quantity);
    public void deleteMedicine(Integer medicine_id);
}
