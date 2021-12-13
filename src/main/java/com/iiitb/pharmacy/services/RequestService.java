package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.Request;
import com.iiitb.pharmacy.dto.Requests;
import java.util.List;

public interface RequestService {
    Request updateRequest(Requests request);

    Request getRequestById(int id);

    List<Request> getRequests();

    Request addRequest(Requests request);
}
