package com.iiitb.pharmacy.dto;


import javax.persistence.criteria.CriteriaBuilder;

public class Sales {
    private Integer sale_id;
    private Double net_diff;
    private String date;
    private Integer cust_id;
    private Integer user_id;

    public Integer getSale_id() {
        return sale_id;
    }

    public void setSale_id(Integer sale_id) {
        this.sale_id = sale_id;
    }

    public Double getNet_diff() {
        return net_diff;
    }

    public void setNet_diff(Double net_diff) {
        this.net_diff = net_diff;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
