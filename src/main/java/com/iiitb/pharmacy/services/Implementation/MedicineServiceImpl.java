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

    public Medicine addMedicine(Medicine medicine){
        medicine.setCost(medicine.getCost()*1.2);
        // check if the medicine exists
        Optional<Medicine> med = medicineDAO.findByName(medicine.getName());

        // doesn't : add a new medicine
        if(med.isEmpty()) return medicineDAO.save(medicine);

        // does : check the cost
        // if medicine has the same cost update the existing entry
        else if(medicine.getCost() == med.get().getCost()){
            int existingStock = med.get().getQuantity_left();
            int updatedStock = existingStock + medicine.getQuantity_left();
            medicine.setQuantity_left(existingStock+updatedStock);
            return medicineDAO.save(medicine);
        }

        // else make a new entry
        else return medicineDAO.save(medicine);
    }

    // to update the medicine stock. update quantity_left
    public Medicine updateMedicine(Medicine medicine, int quantity){
            medicine.setQuantity_left(quantity);
            return medicineDAO.save(medicine);
    }

    public Medicine updateMedicineBySale(Medicine medicine,int quantity){
        if(quantity>medicine.getQuantity_left()) return null;
        medicine.setQuantity_left(medicine.getQuantity_left() - quantity);
        return medicineDAO.save(medicine);
    }
    public Medicine updateMedicineByTransaction(Medicine medicine,int quantity){
        medicine.setQuantity_left(medicine.getQuantity_left() + quantity);
        return medicineDAO.save(medicine);
    }
    public void deleteMedicine(Integer medicine_id){
        Medicine m = medicineDAO.findById(medicine_id).get();
        m.setQuantity_left(0);
        medicineDAO.save(m);
    }

}
