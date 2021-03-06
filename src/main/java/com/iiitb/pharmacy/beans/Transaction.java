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

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transaction_id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String date_of_purchase;

    @ManyToOne
    private Medicine med_id;

    @ManyToOne
    private Vendor ven_id;

    @ManyToOne
    private User user_id;

    public Transaction(Integer quantity, Double price, String formattedDate, Medicine m, Vendor v, User u) {
        this.quantity=quantity;
        this.date_of_purchase=formattedDate;
        this.price=price;
        this.med_id=m;
        this.ven_id=v;
        this.user_id=u;
    }
}

