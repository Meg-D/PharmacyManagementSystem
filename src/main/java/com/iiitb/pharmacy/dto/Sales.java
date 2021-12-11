package com.iiitb.pharmacy.dto;

public class Sales {
    //private Integer sale_id;
    // private Double net_diff;
    private Integer cust_id;
    private Integer user_id;

//    public Integer getSale_id() {
//        return sale_id;
//    }



    public Integer getCust_id() {
        return cust_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Sales(Integer cust_id, Integer user_id) {
       // this.sale_id = sale_id;
       // this.net_diff = net_diff;
        this.cust_id = cust_id;
        this.user_id = user_id;
    }
}
