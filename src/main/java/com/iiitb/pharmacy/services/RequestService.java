package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.Request;

import java.util.List;

public interface RequestService {
    Request updateRequest(Request request);

    Request getRequestById(int id);

    List<Request> getRequests();

    Request addRequest(Request request);
}
