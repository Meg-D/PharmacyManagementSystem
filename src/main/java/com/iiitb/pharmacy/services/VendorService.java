package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.beans.Vendor;

import java.util.List;

public interface VendorService {
    List<Vendor> getVendors();

    Vendor getVendorById(int id);

    void deleteVendor(int parseInt);

    Vendor addVendor(Vendor vendor);
}
