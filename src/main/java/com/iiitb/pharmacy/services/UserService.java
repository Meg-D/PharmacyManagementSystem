package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.User;

public interface UserService {

    public void updateProfile(User user);
    public void addUser(User user);
    public void login(User user);
}
