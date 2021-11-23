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
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

//    @GetMapping("/diff")
//    public Integer getNetDifference(){
//        salesService.getNetDifference();
//    }

    @GetMapping("/generateBill/{saleId}")
    public Double getTotal(@PathVariable String saleId){
        return salesService.getTotal(Integer.parseInt(saleId));
    }

    @GetMapping("/details/{saleId}")
    public Sale viewSaleDetails(@PathVariable String saleId){
        return salesService.viewSaleDetails(Integer.parseInt(saleId));
    }

    @PostMapping("/add")
    public Sale addSale(@RequestBody Sales sale){
        return salesService.addSale(sale);
    }

    @GetMapping("/getByUser/{userId}")
    public Optional<List<Sale>> getSaleByUserId(@PathVariable String userId){
        return salesService.getSaleByUserId(Integer.parseInt(userId));
    }

    @GetMapping("/getByCustomer/{phone}")
    public Optional<List<Sale>> getSaleByCustomerPhone(@PathVariable String phone){
        return salesService.getSaleByCustomerNumber(phone);
    }

}
