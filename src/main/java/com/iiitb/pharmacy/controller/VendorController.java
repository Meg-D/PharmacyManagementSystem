package com.iiitb.pharmacy.controller;

import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.beans.Vendor;
import com.iiitb.pharmacy.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    //get all transactions
    @GetMapping("/vendor")
    public List<Vendor> getVendors(){
        return this.vendorService.getVendors();
    }

    //get transaction by id
    @GetMapping("/vendor/{vendorid}")
    public Vendor getVendorById(@PathVariable String vendorid){
        return this.vendorService.getVendorById(Integer.parseInt(vendorid));
    }

    //delete vendor
    @DeleteMapping("/vendor/{vendorid}")
    public ResponseEntity<HttpStatus> deleteVendor(@PathVariable String vendorId){
        try{
            this.vendorService.deleteVendor(Integer.parseInt(vendorId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //add vendor
    @PostMapping(path="/vendor",consumes = "application/JSON")
    public Vendor addVendor(@RequestBody Vendor vendor){
        return this.vendorService.addVendor(vendor);
    }
}
