package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.beans.Vendor;
import com.iiitb.pharmacy.dao.TransactionDAO;
import com.iiitb.pharmacy.dao.UserDAO;
import com.iiitb.pharmacy.dao.VendorDAO;
import com.iiitb.pharmacy.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Transaction addTransaction(Transaction transaction) {
        return transactionDAO.save(transaction);
    }
}
