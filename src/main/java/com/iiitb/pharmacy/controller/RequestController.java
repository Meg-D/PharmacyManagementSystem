package com.iiitb.pharmacy.controller;

import com.iiitb.pharmacy.beans.Request;
import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RequestController {

    @Autowired
    private RequestService requestService;

    //add request
    @PostMapping(path="/request",consumes = "application/JSON")
    public Request addRequest(@RequestBody Request request){
        return this.requestService.addRequest(request);
    }

    //get all requests
    @GetMapping("/requests")
    public List<Request> getRequests(){
        return this.requestService.getRequests();
    }

    //get request by id
    @GetMapping("/request/{id}")
    public Request getRequestById(@PathVariable String id){
        return this.requestService.getRequestById(Integer.parseInt(id));
    }

    //update request
    @PutMapping(path= "/request/{id}",consumes = "application/JSON")
    public Request updateRequest(@RequestBody Request request){
        return this.requestService.updateRequest(request);
    }
}
