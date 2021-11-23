package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Customer;
import com.iiitb.pharmacy.beans.Sale;
import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.dao.CustomerDAO;
import com.iiitb.pharmacy.dao.ItemDAO;
import com.iiitb.pharmacy.dao.SaleDAO;
import com.iiitb.pharmacy.dao.UserDAO;
import com.iiitb.pharmacy.dto.Sales;
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

    @Autowired
    private ItemDAO itemDAO;

    //public void getNetDifference(){}
    public Sale viewSaleDetails(int saleId){
        return saleDAO.findById(saleId).get();
    }

    public Sale addSale(Sales sale){
        User u = userDAO.getById(sale.getUser_id());
        Customer c = customerDAO.getById(sale.getCust_id());
        Sale s = new Sale(sale.getSale_id(), 0.0, sale.getNet_diff(), sale.getDate(),c,u);
        return saleDAO.save(s);
    }

    @Override
    public Double getTotal(int saleId) {
        Sale obj = new Sale();
        obj.setSale_id(saleId);
        Double bill = 0.0;
        List<Double> amounts = itemDAO.findAmountBySale_id_sale_id(obj);
        for(Double amt:amounts)
            bill +=amt;
        return bill;
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
