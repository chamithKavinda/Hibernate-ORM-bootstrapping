package com.company.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")  //`order`
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_description")
    private String description;

    @CreationTimestamp
    @Column(name = "order_date_time")
    private Timestamp orderDateTime;

    @ManyToOne
    @JoinColumn(name =  "customer_id")
    private  Customer customer;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", description='" + description + '\'' +
                ", orderDateTime='" + orderDateTime + '\'' +
                '}';
    }



    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(Timestamp orderDateTime) {
        this.orderDateTime = orderDateTime;
    }


    public Order(int orderId, String description, Timestamp orderDateTime) {
        this.orderId = orderId;
        this.description = description;
        this.orderDateTime = orderDateTime;
    }

    public Order() {
    }
}
