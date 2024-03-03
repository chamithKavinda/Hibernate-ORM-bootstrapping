package com.company.entity;

import jdk.jfr.Timespan;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
@Entity
@Table(name = "orders")  //`order`
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "order_description")
    private String description;

    @CreationTimestamp
    @Column(name = "order_date_time")
    private String orderDateTime;

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



    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }


    public Order(String orderId, String description, String orderDateTime) {
        this.orderId = orderId;
        this.description = description;
        this.orderDateTime = orderDateTime;
    }

    public Order() {
    }
}
