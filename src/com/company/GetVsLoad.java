package com.company;

import com.company.config.SessionFactoryConfig;
import com.company.entity.Customer;
import org.hibernate.Session;

public class GetVsLoad {
    public  static  void  main(String[] args){

        Session session = SessionFactoryConfig.getInstance().getSession();
        Customer customer = new Customer();
        customer.setName("Saman");
        customer.setAddress("Kaluthara");
        session.save(customer);
        session.close();

        //1.Get
        Session getSession = SessionFactoryConfig
                .getInstance().getSession();

        System.out.println("================Get=================");
        Customer getCustomer = getSession.get(Customer.class,1);
        System.out.println("Customer Id of Get: " + getCustomer.getId());
        System.out.println("Customer Name of Get: " + getCustomer.getName());
        getSession.close();

    }
}
