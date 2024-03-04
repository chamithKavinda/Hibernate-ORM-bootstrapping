package com.company;

import com.company.config.SessionFactoryConfig;
import com.company.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RemovedState {
    public static void main(String[] args){
        Session session = SessionFactoryConfig.getInstance().getSession();
        Customer customer =session.get(Customer.class,1);
        boolean isContains = session.contains(customer);
        extracted(isContains);

        Transaction transaction=session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        boolean contains = session.contains(customer);
        extracted(contains);
    }

    private static void extracted(boolean isContains) {
        if(isContains){
            System.out.println("Customer is in Persistent state");

        }else {
            System.out.println("Customer is in Removed state");

        }
    }
}
