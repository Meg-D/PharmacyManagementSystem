package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Customer;
import com.iiitb.pharmacy.beans.Sale;
import com.iiitb.pharmacy.dao.CustomerDAO;
import com.iiitb.pharmacy.dao.SaleDAO;
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

    public void getNetDifference(){}
    public Sale viewSaleDetails(String saleId){
        return new Sale();
    }

    public Sale addSale(Sale sale){
        return saleDAO.save(sale);
    }

    public Sale getSaleByUserId(String userId){
        return new Sale();
    }

    public Optional<List<Sale>> getSaleByCustomerNumber(String phone){
        Customer c = customerDAO.getCustomerByPhone(phone);
        return saleDAO.findByCustomer(c);
    }

    public void generateBill(){}
}
