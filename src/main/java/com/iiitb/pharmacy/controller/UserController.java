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
    public User updateProfile(@RequestBody User user){
        return userService.updateProfile(user);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/login")
    public User login(@RequestBody User user){
        return userService.login(user);
    }
}
