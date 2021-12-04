package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.Sale;
import com.iiitb.pharmacy.dto.Sales;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface SalesService {

   // public void getNetDifference();
   // public Sale viewSaleDetails(int saleId);
    public Sale addSale(Sales sale);
//    public Double getTotal(int saleId);
    public Sale makeSale(int sale_id);
    public Optional<List<Sale>> getSaleByUserId(int userId);
    public Optional<List<Sale>> getSaleByCustomerNumber(String phone);
    //public void generateBill();
}
