package com.iiitb.pharmacy.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sale_id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Double net_diff;

    @Column
    private String date;

    @ManyToOne
    private Customer cust_id;

    @ManyToOne
    private User user_id;

    public Sale(double v, Double net_diff, Customer c, User u) {
        this.amount=v;
        this.net_diff=net_diff;
        this.cust_id=c;
        this.user_id=u;
    }
}