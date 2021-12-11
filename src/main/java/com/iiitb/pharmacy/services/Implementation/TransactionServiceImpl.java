package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Medicine;
import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.beans.Vendor;
import com.iiitb.pharmacy.dao.MedicineDAO;
import com.iiitb.pharmacy.dao.TransactionDAO;
import com.iiitb.pharmacy.dao.UserDAO;
import com.iiitb.pharmacy.dao.VendorDAO;
import com.iiitb.pharmacy.dto.Transactions;
import com.iiitb.pharmacy.services.MedicineService;
import com.iiitb.pharmacy.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionDAO transactionDAO;
    @Autowired
    private VendorDAO vendorDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private MedicineDAO medicineDAO;
    @Autowired
    private MedicineService medicineService;

    @Override
    public List<Transaction> getTransactions() {
        return transactionDAO.findAll();
    }

    @Override
    public Optional<List<Transaction>> getTransactionsByUserId(int id) {
        Optional<User> u = userDAO.findById(id);
        if(u.isEmpty())
            return null;
        Optional<List<Transaction>> t = transactionDAO.findByUserId(u.get());
        if(t.isEmpty())
            return null;
        return t;
    }

    @Override
    public Optional<List<Transaction>> getTransactionsByVendorId(int id) {
        Optional<Vendor> v = vendorDAO.findById(id);
        if(v.isEmpty())
            return null;
        Optional<List<Transaction>> t = transactionDAO.findByVendorId(v.get());
        if(t.isEmpty())
            return null;
        return t;
    }

    @Override
    public Transaction addTransaction(Transactions transaction) {

       // transaction.setPrice(transaction.getPrice());
        //Medicine m = medicineDAO.getById(transaction.getMedicine_id());
        Medicine med;
        Optional<Medicine> m = medicineDAO.findByNameAndCost(transaction.getMedicine_name(),transaction.getPrice());
        if(m.isEmpty()){
            Medicine m1 = new Medicine(transaction.getMedicine_name(),transaction.getQuantity(),transaction.getPrice()*1.2);
            med = medicineService.addMedicine(m1);
        }
        else{
            med = m.get();
            medicineService.updateMedicineByTransaction(med,transaction.getQuantity());
        }
        User u = userDAO.findById(transaction.getUser_id()).get();
        Vendor v = vendorDAO.findById(transaction.getVendor_id()).get();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = formatter.format(date);
        Transaction t = new Transaction(transaction.getQuantity(),transaction.getPrice(),formattedDate,med,v,u);
        return transactionDAO.save(t);
    }
}
