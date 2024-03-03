package com.company.entity;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id //tells Hibernate that this is the primary key of this
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "customer_id")
    private  int id;

    @Column(name = "Customer_name")
    private  String name;


    @Column(name = "Customer_address")
    private  String address;

    public Customer(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
