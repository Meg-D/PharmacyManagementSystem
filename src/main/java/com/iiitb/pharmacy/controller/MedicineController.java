package com.iiitb.pharmacy.controller;

import java.util.*;
import com.iiitb.pharmacy.beans.Medicine;
import com.iiitb.pharmacy.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    public Medicine getMedicineByName(@PathVariable String medicineName){
        return medicineService.getMedicineByName(medicineName);
    }

    public List<Medicine> getAllMedicines(){
        return medicineService.getAllMedicines();
    }

    public void addMedicine(@RequestBody Medicine medicine){
        medicineService.addMedicine(medicine);
    }

    public void updateMedicine(@RequestBody Medicine medicine){
        medicineService.updateMedicine(medicine);
    }

    public void deleteMedicine(@PathVariable String medicineId){
        medicineService.deleteMedicine(medicineId);
    }
}
