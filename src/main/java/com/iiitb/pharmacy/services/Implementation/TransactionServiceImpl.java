package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.services.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public List<Transaction> getTransactions() {
        return null;
    }

    @Override
    public Transaction getTransactionsById() {
        return null;
    }

    @Override
    public Transaction getTransactionsByVendorId() {
        return null;
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return null;
    }
}
