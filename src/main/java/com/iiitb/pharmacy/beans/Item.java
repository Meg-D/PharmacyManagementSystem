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
    private Double amount;

    @Column(nullable = false)
    private Double discount;

    @ManyToOne
    private Medicine med_id;

    @ManyToOne
    private Sale sale_id;

    public Item(Integer quantity, Double amount, Double discount, Medicine m, Sale s) {
        this.quantity=quantity;
        this.amount=amount;
        this.discount=discount;
        this.med_id=m;
        this.sale_id=s;
    }
}
