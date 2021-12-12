package com.iiitb.pharmacy.controller;

import java.util.*;
import com.iiitb.pharmacy.beans.Medicine;
import com.iiitb.pharmacy.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/get/{medicineName}")
    public Medicine getMedicineByName(@PathVariable String medicineName){
        return medicineService.getMedicineByName(medicineName);
    }

    @GetMapping("/getAll")
    public List<Medicine> getAllMedicines(){
        return medicineService.getAllMedicines();
    }

    @PostMapping(path = "/add",
    produces = {"application/json"},
    consumes = {"application/json"})
    // a form to add a new medicine
    // add medicine when a request is processed
    public Medicine addMedicine(@RequestBody Medicine medicine){
        return this.medicineService.addMedicine(medicine);
    }

    // not required here
    // while adding item, the updateMedicine service will be called directly
    @PutMapping(path = "/update",
    produces = {"application/json"},
    consumes = {"application/json"})
    public Medicine updateMedicine(@RequestBody Medicine medicine){
        return this.medicineService.updateMedicine(medicine, medicine.getQuantity_left());
    }

    @PutMapping(path = "/delete/{id}")
    public void deleteMedicine(@PathVariable String id) {
        this.medicineService.deleteMedicine(Integer.parseInt(id));
    }
}
