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

    @Override
    public User updateProfile(User user){
        return userDAO.save(user);
    }

    @Override
    public User addUser(User user){
        return userDAO.save(user);
    }

    @Override
    public User login(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        return userDAO.findByUsernameEqualsAndPasswordEquals(username,password);
    }

    @Override
    public String changePassword(String email,String old, String newp, String newp2) {
        String check = userDAO.getPasswordByEmail(email);
//        System.out.println(old);
//        System.out.println(check);
        if(!old.equals(check)) return "Old password does not match";
        if(!newp.equals(newp2)) return "Confirm password does not match";
        userDAO.updatePassword(email,newp);
        return "Success";
    }
}
