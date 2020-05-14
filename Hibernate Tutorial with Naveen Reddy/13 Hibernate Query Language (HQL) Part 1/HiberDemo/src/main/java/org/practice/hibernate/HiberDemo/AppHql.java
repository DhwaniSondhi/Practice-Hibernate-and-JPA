package org.practice.hibernate.HiberDemo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.practice.hibernate.HiberDemo.caching.Person;
import org.practice.hibernate.HiberDemo.hql.Student;

public class AppHql 
{
    public static void main( String[] args )
    {
    	Configuration config=new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        
        /*
        Query q=session.createQuery("from Student");
        List<Student> students=q.list();
        students.forEach(student->System.out.println(student));
        */
        
        /*
        Query q=session.createQuery("from Student where marks>50");
        List<Student> students=q.list();
        students.forEach(student->System.out.println(student));
        */
        
        /*
        Query q=session.createQuery("from Student where marks>50 and id=1");
        Student student=(Student) q.uniqueResult();
        if(student!=null) {
        	System.out.println(student);
        }
        */
        
        Query q=session.createQuery("from Student where id=1");
        Student student=(Student) q.uniqueResult();
        if(student!=null) {
        	System.out.println(student);
        }
        
        session.getTransaction().commit();
        session.close();
    }
}
