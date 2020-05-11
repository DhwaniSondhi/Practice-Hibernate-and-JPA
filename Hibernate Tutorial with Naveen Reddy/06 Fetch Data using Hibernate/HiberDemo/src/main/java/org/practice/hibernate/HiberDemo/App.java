package org.practice.hibernate.HiberDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Configuration config=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class);
        SessionFactory sessionFact=config.buildSessionFactory();
        
        Session session=sessionFact.getCurrentSession();
        Transaction transaction=session.getTransaction();
        transaction.begin();
        Person p=session.get(Person.class, 101);
        System.out.println(p);
        transaction.commit();
    }
}
