package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.dto.Transactions;
import java.util.List;
import java.util.Optional;

public interface TransactionService {

    public List<Transaction> getTransactions();
    public Optional<List<Transaction>> getTransactionsByUserId(int user_id);
    public Transaction addTransaction(Transactions transaction);
    public Optional<List<Transaction>> getTransactionsByVendorId(int vendor_id);
}
