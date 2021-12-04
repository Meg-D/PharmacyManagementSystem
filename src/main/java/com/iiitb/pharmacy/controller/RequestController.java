package com.iiitb.pharmacy.controller;

import com.iiitb.pharmacy.beans.Request;
import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.dto.Requests;
import com.iiitb.pharmacy.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    //add request
    @PostMapping(path="/add",consumes = "application/JSON")
    public Request addRequest(@RequestBody Requests request){
        return this.requestService.addRequest(request);
    }

    //get all requests
    @GetMapping("/getall")
    public List<Request> getRequests(){
        return this.requestService.getRequests();
    }

    //get request by id
    @GetMapping("/getbyid/{id}")
    public Request getRequestById(@PathVariable String id){
        return this.requestService.getRequestById(Integer.parseInt(id));
    }

    //update request
    @PutMapping(path= "/update",consumes = "application/JSON")
    public Request updateRequest(@RequestBody Requests request){
        return this.requestService.updateRequest(request);
    }
}
