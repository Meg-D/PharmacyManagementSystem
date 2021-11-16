package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Sale;
import com.iiitb.pharmacy.dao.SaleDAO;
import com.iiitb.pharmacy.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SaleDAO saleDAO;

    public void getNetDifference(){}
    public Sale viewSaleDetails(String saleId){
        return new Sale();
    }

    public void addSale(Sale sale){}

    public Sale getSaleByUserId(String userId){
        return new Sale();
    }

    public Sale getSaleByCustomerId(String customerId){
        return new Sale();
    }

    public void generateBill(){}
}
