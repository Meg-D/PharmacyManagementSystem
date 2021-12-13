package com.iiitb.pharmacy.controller;

import com.iiitb.pharmacy.beans.Vendor;
import com.iiitb.pharmacy.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/vendor")
@RestController
public class VendorController {

    @Autowired
    private VendorService vendorService;

    // get all transactions
    @GetMapping("/getall")
    public List<Vendor> getVendors(){
        return this.vendorService.getVendors();
    }

    // get vendor by id
    @GetMapping("/getbyid/{vendorid}")
    public Vendor getVendorById(@PathVariable String vendorid){
        return this.vendorService.getVendorById(Integer.parseInt(vendorid));
    }

    // delete vendor by id
    @DeleteMapping("/delete/{vendorid}")
    public ResponseEntity<HttpStatus> deleteVendor(@PathVariable String vendorid){
        try{
            this.vendorService.deleteVendor(Integer.parseInt(vendorid));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // add a new vendor
    @PostMapping(path="/add",consumes = "application/JSON")
    public Vendor addVendor(@RequestBody Vendor vendor){
        return this.vendorService.addVendor(vendor);
    }
}
