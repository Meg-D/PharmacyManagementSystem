package com.iiitb.pharmacy.controller;


import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public void updateProfile(@RequestBody User user){}

    public void addUser(@RequestBody User user){}

    public void login(@RequestBody User user){}
}
