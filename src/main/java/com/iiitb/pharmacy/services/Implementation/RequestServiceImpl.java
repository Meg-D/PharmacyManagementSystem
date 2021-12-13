package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.*;
import com.iiitb.pharmacy.dao.*;
import com.iiitb.pharmacy.dto.Requests;
import com.iiitb.pharmacy.dto.Transactions;
import com.iiitb.pharmacy.services.MedicineService;
import com.iiitb.pharmacy.services.RequestService;
import com.iiitb.pharmacy.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestDAO requestDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private VendorDAO vendorDAO;

    @Autowired
    private MedicineDAO medicineDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private MedicineService medicineService;

    @Override
    public Request updateRequest(Requests request) {
        Request r = requestDAO.findById(request.getRequest_id()).get();
        User u = userDAO.findById(request.getAccepted_by()).get();
        Vendor v = vendorDAO.findById(request.getVendor_id()).get();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = formatter.format(date);
        r.setVendor_id(v);
        r.setAccepted_by(u);
        r.setStatus(1);
        r.setDelivery_date(formattedDate);

        Optional<Medicine> meds= medicineDAO.findByNameAndCost(r.getMedicine_name(), request.getPrice());
        Medicine m;
        //System.out.println(r.getMedicine_name());
        if(meds.isEmpty()){
            m = new Medicine(r.getMedicine_name(), r.getQuantity(), request.getPrice());
            medicineDAO.save(m);
        }
        else{
            m = meds.get();
            medicineService.updateMedicineByTransaction(m, r.getQuantity());
        }
        Transaction t = new Transaction(r.getQuantity(),request.getPrice(),formattedDate,m,v,u);
        transactionDAO.save(t);
        return requestDAO.save(r);
    }

    @Override
    public Request getRequestById(int id) {
        Optional<Request> r= requestDAO.findById(id);
        if(r.isEmpty())
            return null;
        return r.get();
    }

    @Override
    public List<Request> getRequests() {
        return requestDAO.findAll();
    }

    @Override
    public Request addRequest(Requests request) {
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        User u = userDAO.findById(request.getPlaced_by()).get();
        Request r = new Request(request.getMedicine_name(),request.getQuantity(),0,formattedDate,u);
        return requestDAO.save(r);
    }
}
