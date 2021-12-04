package com.iiitb.pharmacy.dto;

public class Transactions {
    private Integer quantity;
    private Double price;
    private Integer medicine_id;
    private Integer vendor_id;
    private Integer user_id;


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(Integer medicine_id) {
        this.medicine_id = medicine_id;
    }

    public Integer getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(Integer vendor_id) {
        this.vendor_id = vendor_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Transactions(Integer quantity, Double price, Integer medicine_id, Integer vendor_id, Integer user_id) {
        this.quantity = quantity;
        this.price = price;
        this.medicine_id = medicine_id;
        this.vendor_id = vendor_id;
        this.user_id = user_id;
    }
}
