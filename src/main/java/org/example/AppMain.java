package org.example;

import org.example.model.Customer;
import org.example.model.CustomerDetail;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class AppMain {
    public static void main(String[] args) {

       Customer customer=new Customer();
       customer.setFirstName("Ali");
       customer.setLastName("Akkiraz");

       CustomerDetail customerDetail=new CustomerDetail();
       customerDetail.setAddress("Ankara");
       customerDetail.setPhone("03214568542");
       customerDetail.setRecordDate(new Date());

       customer.setCustomerDetail(customerDetail);
       customerDetail.setCustomer(customer);

        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;

        try {
            transaction=session.beginTransaction();
            session.save(customer);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            System.out.println("Hata: "+e);
        }finally {
            session.close();
        }
    }

}
