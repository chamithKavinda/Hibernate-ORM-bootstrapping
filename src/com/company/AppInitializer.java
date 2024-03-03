package com.company;

import com.company.config.SessionFactoryConfig;
import com.company.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();


        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Saman");
        customer.setAddress("Galle");
        customer.setSalary(25000);

        session.save(customer);
        transaction.commit();
        session.close();

    }
}
