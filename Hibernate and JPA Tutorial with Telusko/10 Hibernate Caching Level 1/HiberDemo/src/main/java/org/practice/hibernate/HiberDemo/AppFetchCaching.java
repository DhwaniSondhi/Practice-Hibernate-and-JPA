package org.practice.hibernate.HiberDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.practice.hibernate.HiberDemo.lazyeager.Laptop;
import org.practice.hibernate.HiberDemo.lazyeager.Person;

public class AppFetchCaching 
{
    public static void main( String[] args )
    {
    	Configuration config=new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session1=sf.openSession();
        session1.beginTransaction();
        Person p1=session1.get(Person.class, 1);
        System.out.println(p1);
        session1.getTransaction().commit();
        session1.close();
        Session session2=sf.openSession();
        session2.beginTransaction();
        Person p2=session2.get(Person.class, 1);
        System.out.println(p2);
        session2.getTransaction().commit();
        session2.close();
    }
}
