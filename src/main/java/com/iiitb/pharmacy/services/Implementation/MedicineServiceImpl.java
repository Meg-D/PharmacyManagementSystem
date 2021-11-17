package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Medicine;
import com.iiitb.pharmacy.dao.MedicineDAO;
import com.iiitb.pharmacy.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    public MedicineDAO medicineDAO;

    public Medicine getMedicineByName(String medicineName){
        Optional<Medicine> med = medicineDAO.findByName(medicineName);
        if(med.isEmpty()) return null;
        return med.get();
    }

    public List<Medicine> getAllMedicines(){
        List<Medicine> medicineList = medicineDAO.findAll();
        return medicineList;
    }

    public void addMedicine(Medicine medicine){
        // check if the medicine exists
        Optional<Medicine> med = medicineDAO.findByName(medicine.getName());

        // doesn't : add a new medicine
        if(med.isEmpty()) medicineDAO.save(medicine);

        // does : check the cost
        // if medicine has the same cost update the existing entry
        else if(medicine.getCost() == med.get().getCost()){
            int existingStock = med.get().getQuantity_left();
            int updatedStock = existingStock + medicine.getQuantity_left();
            medicine.setQuantity_left(existingStock+updatedStock);
            medicineDAO.save(medicine);
        }

        // else make a new entry
        else medicineDAO.save(medicine);
    }

    // to update the medicine stock. update quantity_left
    public void updateMedicine(Medicine medicine, int quantity){
            medicine.setQuantity_left(medicine.getQuantity_left() - quantity);
            medicineDAO.save(medicine);
    }


    public void deleteMedicine(Medicine medicine){
        medicineDAO.delete(medicine);
    }

}
