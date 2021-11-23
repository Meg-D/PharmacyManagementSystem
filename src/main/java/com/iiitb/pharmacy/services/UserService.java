package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.dto.Users;

public interface UserService {

    public User updateProfile(User user);
    public User addUser(User user);
    public User login(Users user);
    public String changePassword(String email,String old, String newp,String newp2);
}
