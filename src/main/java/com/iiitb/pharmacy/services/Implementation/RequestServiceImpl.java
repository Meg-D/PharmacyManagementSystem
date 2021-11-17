package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Request;
import com.iiitb.pharmacy.dao.RequestDAO;
import com.iiitb.pharmacy.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestDAO requestDAO;

    @Override
    public Request updateRequest(Request request) {
        return requestDAO.save(request);
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
    public Request addRequest(Request request) {
        return requestDAO.save(request);
    }
}
