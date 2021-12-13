package com.iiitb.pharmacy.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vendor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vendor_id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String location;

    @Column(nullable=false)
    private String start_date;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

}
