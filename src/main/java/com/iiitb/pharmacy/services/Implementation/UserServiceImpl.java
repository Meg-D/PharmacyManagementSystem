package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.dao.UserDAO;
import com.iiitb.pharmacy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void updateProfile(User user){}

    public void addUser(User user){}

    public void login(User user){}
}
