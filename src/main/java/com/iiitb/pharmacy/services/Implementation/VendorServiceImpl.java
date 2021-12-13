package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Vendor;
import com.iiitb.pharmacy.dao.VendorDAO;
import com.iiitb.pharmacy.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iiitb.pharmacy.utils.generateDate;
import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorDAO vendorDAO;

    // return list of all the vendors
    @Override
    public List<Vendor> getVendors() {
        return vendorDAO.findAll();
    }

    // return vendor associated with the given id
    @Override
    public Vendor getVendorById(int id) {
        Optional<Vendor> vendor = vendorDAO.findById(id);
        if(vendor.isEmpty()) return null;
        return vendor.get();
    }

    // delete vendor with the given id
    @Override
    public void deleteVendor(int id) {
        Optional<Vendor> vendor = vendorDAO.findById(id);
        if(!vendor.isEmpty()) vendorDAO.delete(vendor.get());
        return;
    }

    // add a new vendor
    @Override
    public Vendor addVendor(Vendor vendor) {
        String formattedDate = new generateDate().getFormattedDate("dd/MM/yyyy HH:mm:ss");
        vendor.setStart_date(formattedDate);
        return vendorDAO.save(vendor);
    }
}
