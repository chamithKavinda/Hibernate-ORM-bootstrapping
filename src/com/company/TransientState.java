package com.company;

import com.company.config.SessionFactoryConfig;
import com.company.entity.Customer;
import org.hibernate.Session;

public class TransientState {

    public static void main(String[] args){
        Session session = SessionFactoryConfig.getInstance().getSession();

        //Transient

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Saman");
        customer.setAddress("Colombo");

        boolean isContains = session.contains(customer);
        if(isContains){
            System.out.println("This object is not in  Transient state");
        }else{
            System.out.println("This object is in Transient state");
        }
    }
}
