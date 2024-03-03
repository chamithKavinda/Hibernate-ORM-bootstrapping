package com.company.entity;

import com.company.embedded.MobileNumber;
import com.company.embedded.Nameidentifire;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

//@Entity(name = "customer")
@Entity
@Table(name = "Customer")
public class Customer {

    @Id //tells Hibernate that this is the primary key of this
    @Column(name = "customer_id")
    private int id;


    @Column(name = "customer_name")
    private Nameidentifire name;

    @Column(name = "customer_address" , length = 100 ,nullable = false)
    private  String address;

    @Transient
    @Column(name = "customer_salary")
    private  double salary;

    @CreationTimestamp
    private Timestamp createdDateTime;

    @UpdateTimestamp
    private Timestamp updateDateTime;

    @ElementCollection
    @CollectionTable(name = "customer_mobile_nos" ,joinColumns = @JoinColumn(name = "customer_id"))
    private List<MobileNumber>mobileNumbers = new ArrayList<>();

    @Transient
    @Column(name ="customer_age")
    private int age;

    public Customer(){}

    public Customer(int id, Nameidentifire name, String address, double salary, Timestamp createdDateTime, Timestamp updateDateTime, List<MobileNumber> mobileNumbers, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.createdDateTime = createdDateTime;
        this.updateDateTime = updateDateTime;
        this.mobileNumbers = mobileNumbers;
        this.age = age;
    }

    public Nameidentifire getName() {
        return name;
    }

    public void setName(Nameidentifire name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary + '\'' +
                ", mobileNo=" + mobileNumbers +
                '}';
    }


        public List<MobileNumber> getMobileNumbers() {
            return mobileNumbers;
        }

        public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
            this.mobileNumbers = mobileNumbers;
        }

    public void setAddress(String matara) {
    }

    public void setSalary(int i) {
    }
}
