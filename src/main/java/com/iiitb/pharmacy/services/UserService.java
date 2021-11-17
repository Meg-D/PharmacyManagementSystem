package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.User;

public interface UserService {

    public User updateProfile(User user);
    public User addUser(User user);
    public User login(User user);
    public String changePassword(String email,String old, String newp,String newp2);
}
