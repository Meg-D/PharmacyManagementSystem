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

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer item_id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private Integer discount;

    @ManyToOne
    private Medicine med_id;

    @ManyToOne
    private Customer cust_id;

    @ManyToOne
    private Sale sale_id;
}
