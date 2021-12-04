package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Request;
import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.beans.Vendor;
import com.iiitb.pharmacy.dao.RequestDAO;
import com.iiitb.pharmacy.dao.UserDAO;
import com.iiitb.pharmacy.dao.VendorDAO;
import com.iiitb.pharmacy.dto.Requests;
import com.iiitb.pharmacy.services.RequestService;
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
    @Override
    public Request updateRequest(Requests request) {
        Request r = requestDAO.findById(request.getRequest_id()).get();
        User u = userDAO.findById(request.getAccepted_by()).get();
        Vendor v = vendorDAO.findById(request.getVendor_id()).get();
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);

        r.setVendor_id(v);
        r.setAccepted_by(u);
        r.setStatus(1);
        r.setDelivery_date(formattedDate);
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
