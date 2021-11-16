package com.iiitb.pharmacy.controller;


import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/update")
    public void updateProfile(@RequestBody User user){}

    @PostMapping("/add")
    public void addUser(@RequestBody User user){}

    @GetMapping("/login")
    public void login(@RequestBody User user){}
}
