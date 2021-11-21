package com.iiitb.pharmacy.controller;

import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.dto.Transactions;
import com.iiitb.pharmacy.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/transactions")
@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    //get all transactions
    @GetMapping("/getall")
    public List<Transaction> getTransactions(){
        return this.transactionService.getTransactions();
    }

    //get transaction by user id
    @GetMapping("/getbyuserid/{userid}")
    public Optional<List<Transaction>> getTransactionsUserById(@PathVariable String userid){
        return this.transactionService.getTransactionsByUserId(Integer.parseInt(userid));
    }

    //get transaction by vendor id
    @GetMapping("/getbyvendorid/{vendorid}")
    public Optional<List<Transaction>> getTransactionsByVendorId(@PathVariable String vendorid){
        return this.transactionService.getTransactionsByVendorId(Integer.parseInt(vendorid));
    }

    //add transaction
    @PostMapping(path="/add",consumes = "application/JSON")
    public Transaction addTransaction(@RequestBody Transactions transaction){
        return this.transactionService.addTransaction(transaction);
    }
}
