package org.practice.hibernate.HiberDemo;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.practice.hibernate.HiberDemo.basic.Name;
import org.practice.hibernate.HiberDemo.basic.Person;
import org.practice.hibernate.HiberDemo.mapping.Laptop;
import org.practice.hibernate.HiberDemo.mapping.Student;

public class AppMapping 
{
    public static void main( String[] args )
    {
        Laptop lap=new Laptop
        		.LaptopBuilder()
        		.setId(101)
        		.setName("Dell")
        		.build();
        Student st=new Student
        			.StudentBuilder()
        			.setRollno(1)
        			.setName("Tej")
        			.setMarks(80)
        			.setLaptop(Arrays.asList(lap))
        			.build();
        lap.setSt(Arrays.asList(st));
        Configuration config=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session=sf.getCurrentSession();
        Transaction t=session.getTransaction();
        t.begin();
        session.save(lap);
        session.save(st);
        t.commit();
        						
    }
}
