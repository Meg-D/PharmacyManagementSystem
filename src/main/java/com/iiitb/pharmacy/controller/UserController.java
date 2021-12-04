package com.iiitb.pharmacy.controller;


import com.fasterxml.jackson.core.io.JsonEOFException;
import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.dto.Password;
import com.iiitb.pharmacy.dto.Users;
import com.iiitb.pharmacy.services.UserService;
import org.json.JSONObject;
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

    @GetMapping("/login/{user}")
    public User login(@PathVariable String user){
        JSONObject json = new JSONObject(user);
        Users user1 = new Users();
        user1.setUsername(json.getString("username"));
        user1.setPassword(json.getString("password"));
        return userService.login(user1);
    }

    @PostMapping("/updatePassword")
    public String changePassword(@RequestBody Password password){return userService.changePassword(password.getUsername(), password.getOld(), password.getNewp(), password.getNewp2());}
}
