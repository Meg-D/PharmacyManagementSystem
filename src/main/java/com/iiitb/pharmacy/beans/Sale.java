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

public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sale_id;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private Integer net_diff;

    @Column
    private Date date;

    @ManyToOne
    private Customer cust_id;

    @ManyToOne
    private User user_id;
}