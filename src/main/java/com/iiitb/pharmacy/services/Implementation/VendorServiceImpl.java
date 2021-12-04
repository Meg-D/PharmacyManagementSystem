package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.beans.Vendor;
import com.iiitb.pharmacy.dao.VendorDAO;
import com.iiitb.pharmacy.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorDAO vendorDAO;

    @Override
    public List<Vendor> getVendors() {
        return vendorDAO.findAll();
    }

    @Override
    public Vendor getVendorById(int id) {
        Optional<Vendor> v = vendorDAO.findById(id);
        if(v.isEmpty())
            return null;
        return v.get();
    }

    @Override
    public void deleteVendor(int id) {
        Optional<Vendor> v = vendorDAO.findById(id);
        if(!v.isEmpty())
            vendorDAO.delete(v.get());
        return;
    }

    @Override
    public Vendor addVendor(Vendor vendor) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
       String formattedDate = formatter.format(date);
        vendor.setStart_date(formattedDate);
        return vendorDAO.save(vendor);
    }
}
