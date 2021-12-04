package com.iiitb.pharmacy.dto;

public class Requests {
    private String medicine_name;
    private Integer quantity;
    private Integer placed_by;
    private Integer accepted_by;
    private Integer vendor_id;

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPlaced_by() {
        return placed_by;
    }

    public void setPlaced_by(Integer placed_by) {
        this.placed_by = placed_by;
    }

    public Integer getAccepted_by() {
        return accepted_by;
    }

    public void setAccepted_by(Integer accepted_by) {
        this.accepted_by = accepted_by;
    }

    public Integer getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(Integer vendor_id) {
        this.vendor_id = vendor_id;
    }

    public Requests(String medicine_name, Integer quantity, Integer placed_by) {
        this.medicine_name = medicine_name;
        this.quantity = quantity;
        this.placed_by = placed_by;
        this.accepted_by = null;
        this.vendor_id = null;
    }
}
