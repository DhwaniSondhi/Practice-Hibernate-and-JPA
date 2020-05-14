package org.practice.hibernate.HiberDemo;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.practice.hibernate.HiberDemo.cycles.Laptop;

public class AppCycles 
{
	public static void main( String[] args )
	{
		Configuration config=new Configuration().configure().addAnnotatedClass(Laptop.class);
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		Transaction t=session.getTransaction();
		t.begin();
		//transient
		Laptop l=new Laptop
				.LaptopBuilder()
				.setBrandName("ABC11")
				.setPrice(1000)
				.setId(111)
				.build();

		//persistent
		session.save(l);

		//still persistent
		l.setPrice(650);

		//Detach
		//t.commit();
		//session.detach(l);
		//l.setPrice(550);

		//remove
		session.remove(l);
		t.commit();
		
		session.close();

	}
}
