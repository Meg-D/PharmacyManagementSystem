package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.Transaction;

import java.util.List;

public interface TransactionService {
    public List<Transaction> getTransactions();

    public Transaction getTransactionsById();

    public Transaction getTransactionsByVendorId();

    public Transaction addTransaction(Transaction transaction);
}
