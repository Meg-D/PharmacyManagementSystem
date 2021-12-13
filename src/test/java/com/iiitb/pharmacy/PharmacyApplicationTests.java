package com.iiitb.pharmacy;

import com.iiitb.pharmacy.beans.Customer;
import com.iiitb.pharmacy.beans.Request;
import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.dao.*;
import com.iiitb.pharmacy.dto.Password;
import com.iiitb.pharmacy.dto.Users;
import com.iiitb.pharmacy.services.Implementation.CustomerServiceImpl;
import com.iiitb.pharmacy.services.Implementation.RequestServiceImpl;
import com.iiitb.pharmacy.services.Implementation.UserServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PharmacyApplicationTests {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    RequestServiceImpl requestServiceImpl;

    //testing login
    @Test
    void login() {
        Users user = new Users();
        user.setUsername("Messi");
        user.setPassword("psg");
        User user1 = userServiceImpl.login(user);
        Assert.assertNotNull(user1);

        user.setPassword("wrong");
        user1 = userServiceImpl.login(user);
        Assert.assertNull(user1);
    }

    //testing update password
    @Test
    void updatePassword(){
        String test1 = userServiceImpl.changePassword("Messi","wrong","new1","new2");
        Assert.assertEquals("Old password does not match",test1);
        test1 = userServiceImpl.changePassword("Messi","psg","new1","new2");
        Assert.assertEquals("Confirm password does not match",test1);
        test1 = userServiceImpl.changePassword("Messi","psg","psg","psg");
        Assert.assertEquals("Success",test1);
    }

    //fetching user deatils
    @Test
    void getCustomerByPhoneTest(){
//        Customer customer = customerServiceImpl.getCustomerByContactNumber("13131313");
//        Assert.assertNull(customer);
        Customer customer = customerServiceImpl.getCustomerByContactNumber("1313131313");
        Customer test = customerDAO.findById(4).get();
        Assert.assertNotNull(customer);
        Assert.assertEquals("customer matched",test.getName(),customer.getName());
    }

    //listing pending requests
    @Test
    void getAllPendingRequests(){
        int num = 0;
        List<Request> allReq = requestServiceImpl.getRequests();
        Assert.assertEquals(num,allReq.size());
    }

}
