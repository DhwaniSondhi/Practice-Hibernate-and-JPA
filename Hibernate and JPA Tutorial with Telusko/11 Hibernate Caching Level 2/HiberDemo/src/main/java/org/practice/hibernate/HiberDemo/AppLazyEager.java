package org.practice.hibernate.HiberDemo;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.practice.hibernate.HiberDemo.lazyeager.Laptop;
import org.practice.hibernate.HiberDemo.lazyeager.Person;

public class AppLazyEager 
{
    public static void main( String[] args )
    {
    	Person navin= new Person
				.PersonBuilder()
				.setId(1)
				.setName("Navin")
				.build();
    	Person rahul= new Person
				.PersonBuilder()
				.setId(2)
				.setName("Rahul")
				.build();
    	Person mayank= new Person
        				.PersonBuilder()
        				.setId(3)
        				.setName("Mayank")
        				.build();
    	
    	Laptop dell=new Laptop
    					.LaptopBuilder()
    					.setId(101)
    					.setBrandName("Dell")
    					.setPrice(1000)
    					.setPerson(navin)
    					.build();
    	Laptop apple=new Laptop
				.LaptopBuilder()
				.setId(102)
				.setBrandName("Apple")
				.setPrice(2000)
				.setPerson(mayank)
				.build();
    	Laptop asus=new Laptop
				.LaptopBuilder()
				.setId(103)
				.setBrandName("Asus")
				.setPrice(800)
				.setPerson(navin)
				.build();
    	Laptop acer=new Laptop
				.LaptopBuilder()
				.setId(104)
				.setBrandName("Acer")
				.setPrice(1500)
				.setPerson(mayank)
				.build();
    	Laptop samsung=new Laptop
				.LaptopBuilder()
				.setId(105)
				.setBrandName("Samsung")
				.setPrice(1400)
				.setPerson(navin)
				.build();
    	navin.setLaptops(Arrays.asList(new Laptop[] {dell, asus, samsung}));
    	mayank.setLaptops(Arrays.asList(new Laptop[] {apple, acer}));
        Configuration config=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Person.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session=sf.openSession();
        Transaction t=session.getTransaction();
        t.begin();
        session.save(dell);
        session.save(asus);
        session.save(samsung);
        session.save(apple);
        session.save(acer);
        session.save(navin);
        session.save(mayank);
        session.save(rahul);
        t.commit();
        session.close();
        						
    }
}
