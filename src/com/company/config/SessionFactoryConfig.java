package com.company.config;

import com.company.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;

    private  final SessionFactory sessionFactory;

    private SessionFactoryConfig() {
        //1.create a Service Registry
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        // 2.create a MetaData object
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .build();

        // 3.Create a Session Factory
        sessionFactory = metadata
                .buildSessionFactory();
    }

    private SessionFactoryConfig(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public static SessionFactoryConfig getInstance(){
        return (null == factoryConfig) ? factoryConfig = new SessionFactoryConfig(): factoryConfig;
    }

    public Session getSession(){
        //1. Create a Service Registry
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        //2. Create a Metadata object
        Metadata metadata = new MetadataSources(serviceRegistry)
                 .addAnnotatedClass(Customer.class)
                .getMetadataBuilder().build();

        //3. Create a Session Factory
        SessionFactory sessionFactory = metadata.buildSessionFactory();

        //create add open the session
        return sessionFactory.openSession();
    }
}
