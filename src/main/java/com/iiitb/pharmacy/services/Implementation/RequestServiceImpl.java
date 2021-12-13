package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.*;
import com.iiitb.pharmacy.dao.*;
import com.iiitb.pharmacy.dto.Requests;
import com.iiitb.pharmacy.services.MedicineService;
import com.iiitb.pharmacy.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iiitb.pharmacy.utils.generateDate;
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

        // ------------------------- Update Request table -------------------------
        // fetch request from db that matches request_id of incoming request
        Request db_request = requestDAO.findById(request.getRequest_id()).get();
        User u = userDAO.findById(request.getAccepted_by()).get();
        Vendor v = vendorDAO.findById(request.getVendor_id()).get();


        String formattedDate = new generateDate().getFormattedDate("dd/MM/yyyy HH:mm:ss");

        // update fields corresponding to the request being fulfilled
        db_request.setVendor_id(v);
        db_request.setAccepted_by(u);
        db_request.setStatus(1);
        db_request.setDelivery_date(formattedDate);


        // ------------------------- Update Medicine table -------------------------

        Optional<Medicine> meds= medicineDAO.findByNameAndCost(db_request.getMedicine_name(), request.getPrice());
        Medicine m;

        // medicine doesn't exist. Make a new entry
        if(meds.isEmpty()){
            m = new Medicine(db_request.getMedicine_name(), db_request.getQuantity(), request.getPrice());
            medicineDAO.save(m);
        }

        // exists. Update the existing entry
        else{
            m = meds.get();
            medicineService.updateMedicineByTransaction(m, db_request.getQuantity());
        }

        // ------------------------- Update Transaction table -------------------------
        Transaction t = new Transaction(db_request.getQuantity(),request.getPrice(),formattedDate,m,v,u);
        transactionDAO.save(t);

        return requestDAO.save(db_request);
    }

    // return request identified by id
    @Override
    public Request getRequestById(int id) {
        Optional<Request> request= requestDAO.findById(id);

        // request doesn't exist
        if(request.isEmpty()) return null;

        // return request
        return request.get();
    }

    // return list of all the requests
    @Override
    public List<Request> getRequests() {
        return requestDAO.findAll();
    }

    // add a new request
    @Override
    public Request addRequest(Requests request) {

        String formattedDate = new generateDate().getFormattedDate("hh:mm:ss a");
        User user = userDAO.findById(request.getPlaced_by()).get();
        Request new_request = new Request(request.getMedicine_name(),request.getQuantity(),0,formattedDate,user);
        return requestDAO.save(new_request);
    }
}
