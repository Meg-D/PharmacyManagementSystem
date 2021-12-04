package com.iiitb.pharmacy.dto;

public class Items {
    //private Integer item_id;
    private Integer quantity;
    private Double discount;
    private Integer med_id;
    //private Integer cust_id;
    private Integer sale_id;

//   public Integer getItem_id() {
//        return item_id;
//    }
//
//    public void setItem_id(Integer item_id) {
//        this.item_id = item_id;
//    }

    public Integer getQuantity() {
        return quantity;
    }
    public Double getDiscount() {
        return discount;
    }


    public Integer getMed_id() {
        return med_id;
    }

    public void setMed_id(Integer med_id) {
        this.med_id = med_id;
    }

    //public Integer getCust_id() {
    //    return cust_id;
    //}

    //public void setCust_id(Integer cust_id) {
       // this.cust_id = cust_id;
    //}

    public Integer getSale_id() {
        return sale_id;
    }

    public void setSale_id(Integer sale_id) {
        this.sale_id = sale_id;
    }
}
