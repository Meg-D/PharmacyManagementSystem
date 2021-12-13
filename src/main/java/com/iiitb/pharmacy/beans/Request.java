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
    private String order_date;

    @Column
    private String delivery_date;

    @ManyToOne
    private User placed_by;

    @ManyToOne
    private User accepted_by;

    @ManyToOne
    private Vendor vendor_id;

    public Request(String medicine_name, Integer quantity, int i, String formattedDate, User u) {
        this.medicine_name=medicine_name;
        this.quantity=quantity;
        this.status=i;
        this.order_date=formattedDate;
        this.delivery_date=null;
        this.placed_by=u;
        this.accepted_by=null;
        this.vendor_id=null;

    }
}

