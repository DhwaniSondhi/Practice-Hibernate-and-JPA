package org.practice.hibernate.HiberDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.practice.hibernate.HiberDemo.caching.Person;

public class AppWriteForCaching {

	public static void main(String[] args) {
		Person p=new Person
				.PersonBuilder()
				.setId(101)
				.setName("Tej")
				.setColor("Green")
				.build();

		Configuration config=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class);
		SessionFactory sessionFact=config.buildSessionFactory();

		Session session=sessionFact.getCurrentSession();
		Transaction transaction=session.getTransaction();
		transaction.begin();
		session.save(p);
		transaction.commit();
	}
}
