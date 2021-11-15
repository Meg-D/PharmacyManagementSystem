package com.iiitb.pharmacy.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer request_id;

    @Column(nullable = false)
    private String medicine_name;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer status;

    @Column(nullable = false)
    private Date order_date;

    @Column
    private Date delivery_date;

    @ManyToOne
    private User placed_by;

    @ManyToOne
    private User accepted_by;

    @ManyToOne
    private Vendor vendor_id;
}

