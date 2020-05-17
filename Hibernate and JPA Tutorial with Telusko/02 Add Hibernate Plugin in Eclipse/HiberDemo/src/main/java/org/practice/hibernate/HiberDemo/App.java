package org.practice.hibernate.HiberDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person p=new Person();
        p.setId(101);
        p.setName("Tej");
        p.setColor("Green");
        
        Configuration config=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class);
        SessionFactory sessionFact=config.buildSessionFactory();
        
        Session session=sessionFact.getCurrentSession();
        Transaction transaction=session.getTransaction();
        transaction.begin();
        session.save(p);
        transaction.commit();
    }
}
