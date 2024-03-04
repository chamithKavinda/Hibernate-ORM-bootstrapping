package com.company.repository;


import com.company.config.SessionFactoryConfig;
import com.company.entity.Customer;
import com.company.entity.Order;
import com.company.projection.CustomerProjection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.lang.annotation.Native;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

public class CustomerRepository {
    private final Session session;

    public CustomerRepository(){
        session = SessionFactoryConfig
                .getInstance()
                .getSession();
    }
    public int saveCustomer(Customer customer){
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

    public Customer getCustomer(int id) throws RuntimeException {
        try {
            Customer customer = session
                    .get(Customer.class, id);
            session.close();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            throw  e;
        }
    }


    public boolean updateCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
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

    public boolean deleteCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        try{
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

    public List<Object[]> getAllCustomersNative() {
        String sql = "SELECT * FROM customer";
        NativeQuery query = session.createSQLQuery(sql);
        List<Object[]> list = query.list();
        for (Object customer : list) {
            System.out.println(customer);
        }
        session.close();
        return list;
    }

    public List<Customer> getAllCustomerJPQL(){
        String sql = "SELECT C FROM Customer AS C";
        Query query = session.createQuery(sql);
        List<Customer> list = query.list();
        session.close();
        return list;
    }

    public List<Order> getOrdersByCustomerId(int cusId){
        String sql = "SELECT O FROM Order AS O\n" + "INNER JOIN Customer AS C\n" + "ON O.customer.id = C.id\n" + "WHERE O.customer.id = :cus_id";
        Query query = session.createQuery(sql);
        query.setParameter("cus_id", cusId);
        List<Order> list = query.list();
//        session.close();
        return list;
    }

    public List<Customer> getCustomerHQL(){
        String sql = "FROM Customer";
        Query query = session.createQuery(sql);
        List<Customer> list =query.list();
        session.close();
        return list;
    }

    public List<CustomerProjection>  getCustomerProjection(){
        String sql = "SELECT new projection.CustomerProjection(C.id,C.name)" +
                "FROM Customer AS C";
        Query query=session.createQuery(sql) ;
        List list =query.list();
        session.close();
        return list;
    }
}
