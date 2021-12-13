package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.dao.UserDAO;
import com.iiitb.pharmacy.dto.Users;
import com.iiitb.pharmacy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    // update user profile
    @Override
    public User updateProfile(User user){
        return userDAO.save(user);
    }

    // add a new user
    @Override
    public User addUser(User user){
        return userDAO.save(user);
    }

    // user login
    @Override
    public User login(Users user){
        String username = user.getUsername();
        String password = user.getPassword();
        return userDAO.findByUsernameEqualsAndPasswordEquals(username,password);
    }

    // change password
    @Override
    public String changePassword(String email,String old, String newp, String newp2) {
        String check = userDAO.getPasswordByEmail(email);
        if(!old.equals(check)) return "Old password does not match";
        if(!newp.equals(newp2)) return "Confirm password does not match";
        userDAO.updatePassword(email,newp);
        return "Success";
    }
}
