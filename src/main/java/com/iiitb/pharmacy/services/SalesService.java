package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.Sale;

import java.util.List;
import java.util.Optional;

public interface SalesService {

    public void getNetDifference();
    public Sale viewSaleDetails(String saleId);
    public Sale addSale(Sale sale);
    public Sale getSaleByUserId(String userId);
    public Optional<List<Sale>> getSaleByCustomerNumber(String phone);
    public void generateBill();
}
