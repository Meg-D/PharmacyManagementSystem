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

    @GetMapping("/get/{medicineName}")
    public Medicine getMedicineByName(@PathVariable String medicineName){
        return medicineService.getMedicineByName(medicineName);
    }

    @GetMapping("/medicineList")
    public List<Medicine> getAllMedicines(){
        return medicineService.getAllMedicines();
    }

    @PostMapping(path = "/add",
    produces = {"application/json"},
    consumes = {"application/json"})
    // a form to add a new medicine
    // add medicine when a request is processed
    public void addMedicine(@RequestBody Medicine medicine){
        medicineService.addMedicine(medicine);
    }

    // not required here
    // while adding item, the updateMedicine service will be called directly
    @PostMapping(path = "/update",
    produces = {"application/json"},
    consumes = {"application/json"})
    public void updateMedicine(@RequestBody Medicine medicine){
        medicineService.updateMedicine(medicine,2);
    }

    @DeleteMapping(path = "/delete")
    public void deleteMedicine(@RequestBody Medicine medicine){
        medicineService.deleteMedicine(medicine);
    }
}
