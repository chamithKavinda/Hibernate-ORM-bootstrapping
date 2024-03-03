package com.company.repository;


import com.company.config.SessionFactoryConfig;
import com.company.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerRepository {
    private  final Session session;
    public  CustomerRepository(){
        session = SessionFactoryConfig
                .getInstance()
                .getSession();
    }
    public  int saveCustomer(Customer customer){
        /*  Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
        return 0;*/

        Transaction transaction = session.beginTransaction();
        try {
            int customerId = (int) session.save(customer);
            transaction.commit();
            session.close();
            return customerId;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return  -1;
        }
    }

    public  Customer getCustomer(int id) throws  RuntimeException{
        try{
            Customer customer = session.get(Customer.class,id);
            session.close();
            return  customer;
        }catch (Exception e){
            e.printStackTrace();
            session.close();
            throw  e;
        }
    }


    public  boolean updateCustomer(Customer customer){
        Transaction transaction =session.beginTransaction();
        try {
            session.update(customer);
            transaction.commit();
            session.close();
            return  true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return  false;

        }

    }

    public  boolean deleteCustomer(Customer customer){
        Transaction transaction =session.beginTransaction();
        try {
            session.delete(customer);
            transaction.commit();
            session.close();
            return  true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return  false;
        }

    }
}
