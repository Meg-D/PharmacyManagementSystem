package com.iiitb.pharmacy.dto;

public class Sales {

    private Integer cust_id;
    private Integer user_id;


    public Integer getCust_id() {
        return cust_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Sales(Integer cust_id, Integer user_id) {
        this.cust_id = cust_id;
        this.user_id = user_id;
    }
}
