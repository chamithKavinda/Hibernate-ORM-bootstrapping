package com.company;

import com.company.config.SessionFactoryConfig;
import com.company.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersistentState {
    public static void main(String[] args){
        Session session = SessionFactoryConfig.getInstance().getSession();

        //Transient State

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

        //Persistent State

        Transaction transaction = session.beginTransaction();
        int cusId=(int) session.save(customer);
        transaction.commit();

        System.out.println("cusId :" + cusId);
        boolean isPersistent = session.contains(customer);
        if(isPersistent){
            System.out.println("This object is in Persistent state");
        }else{
            System.out.println("This object is not in Persistent state");
        }
        session.close();

    }
}
