package org.practice.hibernate.HiberDemo;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.practice.hibernate.HiberDemo.cycles.Laptop;

public class AppGetLoad 
{
	public static void main( String[] args )
	{
		Configuration config=new Configuration().configure().addAnnotatedClass(Laptop.class);
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		Laptop l1=session.get(Laptop.class, 106);
		System.out.println(l1);
		
		Laptop l2=session.load(Laptop.class, 107);
		System.out.println(l2);
		
		session.getTransaction().commit();
		session.close();

	}
}
