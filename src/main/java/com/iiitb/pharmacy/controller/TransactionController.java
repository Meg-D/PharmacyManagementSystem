package com.iiitb.pharmacy.controller;

import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    //get all transactions
    @GetMapping("/transactions")
    public List<Transaction> getTransactions(){
        return this.transactionService.getTransactions();
    }

    //get transaction by id
    @GetMapping("/transactions/{id}")
    public Transaction getTransactionsById(@PathVariable String id){
        return this.transactionService.getTransactionsById(Integer.parseInt(id));
    }

    //get transaction by vendor id
    @GetMapping("/transactions/{vendorid}")
    public Transaction getTransactionsByVendorId(@PathVariable String vendorid){
        return this.transactionService.getTransactionsByVendorId(Integer.parseInt(vendorid));
    }

    //add transaction
    @PostMapping(path="/transaction",consumes = "application/JSON")
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return this.transactionService.addTransaction(transaction);
    }
}
