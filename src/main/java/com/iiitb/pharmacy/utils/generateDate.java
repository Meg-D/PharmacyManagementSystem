package com.iiitb.pharmacy.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class generateDate {

    private Date date;
    private SimpleDateFormat formatter;
    private String formattedDate;


    public String getFormattedDate(String formatter){
        this.date = new Date();
        this.formatter = new SimpleDateFormat(formatter);
        this.formattedDate = this.formatter.format(this.date);
        return this.formattedDate;
    }
}
