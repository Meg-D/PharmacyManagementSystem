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
import com.iiitb.pharmacy.utils.generateDate;
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

    // get list of all the transactions
    @Override
    public List<Transaction> getTransactions() {
        return transactionDAO.findAll();
    }

    // get list of transactions based on user id
    @Override
    public Optional<List<Transaction>> getTransactionsByUserId(int id) {
        Optional<User> user = userDAO.findById(id);
        if(user.isEmpty()) return null;

        Optional<List<Transaction>> transactionList = transactionDAO.findByUserId(user.get());
        if(transactionList.isEmpty()) return null;
        return transactionList;
    }

    // get list of transactions based on vendor id
    @Override
    public Optional<List<Transaction>> getTransactionsByVendorId(int id) {
        Optional<Vendor> vendor = vendorDAO.findById(id);
        if(vendor.isEmpty()) return null;

        Optional<List<Transaction>> transactionList = transactionDAO.findByVendorId(vendor.get());
        if(transactionList.isEmpty()) return null;

        return transactionList;
    }


    // add a transaction
    @Override
    public Transaction addTransaction(Transactions transaction) {

        Medicine medicine;
        Optional<Medicine> db_medicine = medicineDAO.findByNameAndCost(transaction.getMedicine_name(),transaction.getPrice());

        // medicine doesn't exist : add a new one
        if(db_medicine.isEmpty()){
            Medicine m1 = new Medicine(transaction.getMedicine_name(),transaction.getQuantity(),transaction.getPrice()*1.2);
            medicine = medicineService.addMedicine(m1);
        }

        // it does exist : update existing entry
        else{
            medicine = db_medicine.get();
            medicineService.updateMedicineByTransaction(medicine,transaction.getQuantity());
        }

        User user = userDAO.findById(transaction.getUser_id()).get();
        Vendor v = vendorDAO.findById(transaction.getVendor_id()).get();

        String formattedDate = new generateDate().getFormattedDate("dd/MM/yyyy HH:mm:ss");

        Transaction new_transaction = new Transaction(transaction.getQuantity(),transaction.getPrice(),formattedDate,medicine,v,user);
        return transactionDAO.save(new_transaction);
    }
}
