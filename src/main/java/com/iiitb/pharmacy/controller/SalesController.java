package com.iiitb.pharmacy.controller;

import com.iiitb.pharmacy.beans.Sale;
import com.iiitb.pharmacy.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/diff")
    public void getNetDifference(){
        salesService.getNetDifference();
    }

    @GetMapping("/details/{saleId}")
    public Sale viewSaleDetails(@PathVariable String saleId){
        return salesService.viewSaleDetails(saleId);
    }

    @PostMapping("/add")
    public Sale addSale(Sale sale){
        return salesService.addSale(sale);
    }

    @GetMapping("/getByUser/{userId}")
    public Sale getSaleByUserId(@PathVariable String userId){
        return salesService.getSaleByUserId(userId);
    }

    @GetMapping("/getByCustomer/{customerId}")
    public Optional<List<Sale>> getSaleByCustomerId(@PathVariable String phone){
        return salesService.getSaleByCustomerNumber(phone);
    }

}
