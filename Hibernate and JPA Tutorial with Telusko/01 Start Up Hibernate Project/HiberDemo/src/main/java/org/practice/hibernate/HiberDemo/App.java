package org.practice.hibernate.HiberDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        
        Configuration config=new Configuration();
        SessionFactory sessionFact=config.buildSessionFactory();
        
        Session session=sessionFact.getCurrentSession();
        session.save(p);
    }
}
