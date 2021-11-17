package com.iiitb.pharmacy.beans;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column
    private String address;

    public User(){

    }

    public User(Integer user_id, String username, String password, String phone, String address) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
}
