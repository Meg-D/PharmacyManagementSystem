package com.iiitb.pharmacy.controller;

import java.util.*;
import com.iiitb.pharmacy.beans.Medicine;
import com.iiitb.pharmacy.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;


    // return list of all the medicines
    @GetMapping("/getAll")
    public List<Medicine> getAllMedicines(){
        return medicineService.getAllMedicines();
    }


    // form to add a new medicine
    // add medicine when a request is processed
    @PostMapping(path = "/add",
    produces = {"application/json"},
    consumes = {"application/json"})
    public Medicine addMedicine(@RequestBody Medicine medicine){
        return this.medicineService.addMedicine(medicine);
    }


    // update an existing medicine : case - expired, etc
    @PutMapping(path = "/update",
    produces = {"application/json"},
    consumes = {"application/json"})
    public Medicine updateMedicine(@RequestBody Medicine medicine){
        return this.medicineService.updateMedicine(medicine, medicine.getQuantity_left());
    }

    // delete medicine entry : set quantity to 0
    @PutMapping(path = "/delete/{id}")
    public void deleteMedicine(@PathVariable String id) {
        this.medicineService.deleteMedicine(Integer.parseInt(id));
    }
}
