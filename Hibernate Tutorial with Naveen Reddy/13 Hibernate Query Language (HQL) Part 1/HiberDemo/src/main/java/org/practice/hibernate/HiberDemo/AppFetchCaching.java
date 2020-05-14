package org.practice.hibernate.HiberDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.practice.hibernate.HiberDemo.caching.Person;

public class AppFetchCaching 
{
    public static void main( String[] args )
    {
    	Configuration config=new Configuration().configure().addAnnotatedClass(Person.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session1=sf.openSession();
        session1.beginTransaction();
        Query q1=session1.createQuery("from Person where id=101");
        q1.setCacheable(true);
        Person p1=(Person) q1.uniqueResult();
        System.out.println(p1);
        session1.getTransaction().commit();
        session1.close();
        Session session2=sf.openSession();
        session2.beginTransaction();
        Query q2=session2.createQuery("from Person where id=101");
        q2.setCacheable(true);
        Person p2=(Person) q2.uniqueResult();
        System.out.println(p2);
        session2.getTransaction().commit();
        session2.close();
    }
}
