package com.company;

import com.company.config.SessionFactoryConfig;
import com.company.embedded.MobileNumber;
import com.company.embedded.Nameidentifire;
import com.company.entity.Customer;
import com.company.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AppInitializer {
    public static void main(String[] args) {

        //1.save
        System.out.println("------------ save ------------");
        /*Session session = SessionFactoryConfig.getInstance().getSession();


        Transaction transaction = session.beginTransaction();
        Customer customer = getCustomer();
        session.save(customer);
        transaction.commit();
        session.close();*/

        /*Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Saman");
        customer.setAddress("Galle");
        customer.setSalary(25000);
         session.save(customer);*/

        CustomerRepository customerRepository =new CustomerRepository();
        customerRepository.saveCustomer(getCustomer());

        customerRepository = new CustomerRepository();
        Customer customer = customerRepository.getCustomer(1);
        System.out.println(customer);

        customerRepository = new CustomerRepository();
        customer.setAddress("Galle");
        customerRepository.updateCustomer(customer);
    }
//            //2.get
//        System.out.println("----------GET-----------");
//        Session getSession = SessionFactoryConfig.getInstance().getSession();
//        Customer existCustomer = getSession.get(Customer.class, 1);
//        System.out.println("Existing Customer:" + existCustomer.toString());
//        getSession.close();
//
//
//        //3.update
//        System.out.println("----------UPDATE-----------");
//        Session updateSession = SessionFactoryConfig.getInstance().getSession();
//        Transaction updateTransaction =updateSession.beginTransaction();
//        Customer existCus = updateSession.get(Customer.class,1);
//        existCus.setAddress("Matara");
//        updateSession.update(existCus);
//        updateTransaction.commit();
//        updateSession.close();
//
//
//        //4.delete
//        System.out.println("----------DELETE-----------");
//        Session deleteSession =SessionFactoryConfig.getInstance().getSession();
//        Transaction deleteTransaction = deleteSession.beginTransaction();
//        Customer deleteCus =deleteSession.get(Customer.class,1);
//        deleteSession.delete(deleteCus);
//        deleteTransaction.commit();
//        deleteSession.close();
//        }


    private static Customer getCustomer() {

        Customer customer = new Customer();
        customer.setId(5);
        Nameidentifire nameidentifire =  getNameIdentifire();
        MobileNumber homeNo =new MobileNumber();
        homeNo.setType("Home");
        homeNo.setMobileNo("0412229821");

        MobileNumber mobileNo = new MobileNumber();
        mobileNo.setType("Mobile");
        mobileNo.setMobileNo("0716490250");

        List<MobileNumber> mobileNumbers = new ArrayList<>();
        mobileNumbers.add(homeNo);
        mobileNumbers.add(mobileNo);
        customer.setMobileNumbers(mobileNumbers);

//          nameidentifire.setFirstName("Saman");
//          nameidentifire.setMiddleName("De");
//          nameidentifire.setLastName("Silva");
        customer.setName(nameidentifire);
        customer.setAddress("Matara");
        customer.setSalary(50000);
        return customer;
    }

    private static Nameidentifire getNameIdentifire(){
        Nameidentifire nameidentifire = new Nameidentifire();
        nameidentifire.setFirstName("Saman");
        nameidentifire.setMiddleName("De");
        nameidentifire.setLastName("Silva");
        return nameidentifire;
    }
}
