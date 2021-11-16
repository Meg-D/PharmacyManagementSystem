package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.Transaction;

import java.util.List;

public interface TransactionService {
    public List<Transaction> getTransactions();

    public Transaction getTransactionsById(int id);

    public Transaction getTransactionsByVendorId(int vendorId);

    public Transaction addTransaction(Transaction transaction);
}
