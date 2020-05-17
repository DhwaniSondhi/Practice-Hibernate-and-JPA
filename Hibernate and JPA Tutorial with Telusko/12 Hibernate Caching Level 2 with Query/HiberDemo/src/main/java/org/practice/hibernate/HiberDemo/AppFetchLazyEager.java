package org.practice.hibernate.HiberDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.practice.hibernate.HiberDemo.lazyeager.Laptop;
import org.practice.hibernate.HiberDemo.lazyeager.Person;

public class AppFetchLazyEager 
{
    public static void main( String[] args )
    {
    	Configuration config=new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        Person p1=session.get(Person.class, 1);
        System.out.println(p1.getName());
        System.out.println(p1.getLaptops().size());
        session.getTransaction().commit();
        session.close();
    }
}
