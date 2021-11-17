package com.iiitb.pharmacy;

import com.iiitb.pharmacy.beans.Medicine;
import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.beans.Vendor;
import com.iiitb.pharmacy.dao.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class PharmacyApplication {

    @Autowired
    UserDAO userDAO;

    @Autowired
    MedicineDAO medicineDAO;


    @Autowired
    VendorDAO vendorDAO;

    public static void main(String[] args) {
        SpringApplication.run(PharmacyApplication.class, args);
    }

    @Bean
    InitializingBean App(){
        return () ->
        {
            userDAO.save(new User(1,"meghna","123","987","add"));
            userDAO.save(new User(2,"nupur","123","98765","add2"));

            vendorDAO.save(new Vendor(1,"vendor1","bangalore","12-08-98","vendor1","098"));

            medicineDAO.save(new Medicine(1,"crocin",9,20));
            medicineDAO.save(new Medicine(2,"cetrazine",4,15));
        };
    }
}
