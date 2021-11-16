package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Medicine;
import com.iiitb.pharmacy.dao.MedicineDAO;
import com.iiitb.pharmacy.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

public class MedicineServiceImpl implements MedicineService {

    @Autowired
    public MedicineDAO medicineDAO;

    public Medicine getMedicineByName(String medicineName){
        return new Medicine();
    }

    public List<Medicine> getAllMedicines(){
        return new ArrayList<>();
    }

    public void addMedicine(Medicine medicine){

    }


}
