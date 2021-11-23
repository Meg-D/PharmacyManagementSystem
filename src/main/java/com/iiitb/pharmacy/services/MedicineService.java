package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.Medicine;
import org.springframework.stereotype.Service;

import java.util.*;

public interface MedicineService {

    public Medicine getMedicineByName(String medicineName);
    public List<Medicine> getAllMedicines();
    public void addMedicine(Medicine medicine);
    public void updateMedicine(Medicine medicine, int quantity);
    public void deleteMedicine(Integer medicine_id);
}
