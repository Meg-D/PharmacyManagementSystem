package com.iiitb.pharmacy.controller;

import com.iiitb.pharmacy.beans.Sale;
import com.iiitb.pharmacy.dto.Sales;
import com.iiitb.pharmacy.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/sale")
public class SalesController {

    @Autowired
    private SalesService salesService;


    // update sale with the given id
    @PutMapping("/update/{saleId}")
    public Sale makeSale(@PathVariable String saleId){
        return salesService.makeSale(Integer.parseInt(saleId));
    }

    // make a new sale
    @PostMapping("/add")
    public Sale addSale(@RequestBody Sales sale){
        return salesService.addSale(sale);
    }

    // get sale list associated with the user id
    @GetMapping("/getByUser/{userId}")
    public Optional<List<Sale>> getSaleByUserId(@PathVariable String userId){
        return salesService.getSaleByUserId(Integer.parseInt(userId));
    }

    // get customer's purchase history
    @GetMapping("/getByCustomer/{phone}")
    public Optional<List<Sale>> getSaleByCustomerPhone(@PathVariable String phone){
        return salesService.getSaleByCustomerNumber(phone);
    }

}
