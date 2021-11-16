package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.Sale;

public interface SalesService {

    public void getNetDifference();
    public Sale viewSaleDetails(String saleId);
    public void addSale(Sale sale);
    public Sale getSaleByUserId(String userId);
    public Sale getSaleByCustomerId(String customerId);
    public void generateBill();
}
