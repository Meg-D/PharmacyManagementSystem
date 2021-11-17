package com.iiitb.pharmacy.controller;

import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<List<Transaction>> getTransactionsUserById(@PathVariable String userid){
        return this.transactionService.getTransactionsByUserId(Integer.parseInt(userid));
    }

    //get transaction by vendor id
    @GetMapping("/transactions/{vendorid}")
    public Optional<List<Transaction>> getTransactionsByVendorId(@PathVariable String vendorid){
        return this.transactionService.getTransactionsByVendorId(Integer.parseInt(vendorid));
    }

    //add transaction
    @PostMapping(path="/transaction",consumes = "application/JSON")
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return this.transactionService.addTransaction(transaction);
    }
}
