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
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicine_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer quantity_left;

    @Column(nullable = false)
    private Integer cost;
}

