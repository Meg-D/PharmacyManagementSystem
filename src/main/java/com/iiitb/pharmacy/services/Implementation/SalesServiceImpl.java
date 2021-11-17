package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Customer;
import com.iiitb.pharmacy.beans.Sale;
import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.dao.CustomerDAO;
import com.iiitb.pharmacy.dao.SaleDAO;
import com.iiitb.pharmacy.dao.UserDAO;
import com.iiitb.pharmacy.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SaleDAO saleDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private UserDAO userDAO;

    //public void getNetDifference(){}
    public Sale viewSaleDetails(int saleId){
        return saleDAO.findById(saleId).get();
    }

    public Sale addSale(Sale sale){
        return saleDAO.save(sale);
    }

    public Optional<List<Sale>> getSaleByUserId(int userId){
        Optional<User> u = userDAO.findById(userId);
        if(!u.isEmpty())
            return saleDAO.findByUser(u.get());
        return null;
    }

    public Optional<List<Sale>> getSaleByCustomerNumber(String phone){
        Optional<Customer> c = customerDAO.findByPhone(phone);
        if(!c.isEmpty())
            return saleDAO.findByCustomer(c.get());
        return null;
    }

   // public void generateBill(){}
}
