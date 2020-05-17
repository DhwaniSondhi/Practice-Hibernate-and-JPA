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
        Query q=session.createQuery("Select id, name, marks from Student where id=1");
        Object[] student=(Object[]) q.uniqueResult();
        System.out.println(student[0]+" "+student[1]+" "+student[2]);
       	*/
        
        /*
        Query q=session.createQuery("Select id, name, marks from Student");
        List<Object[]> students=(List<Object[]>) q.list();
        students.forEach(student->System.out.println(student[0]+" "+student[1]+" "+student[2]));
         */
        /*
        Query q=session.createQuery("Select id, name, marks from Student s where s.marks>60");
        List<Object[]> students=(List<Object[]>) q.list();
        students.forEach(student->System.out.println(student[0]+" "+student[1]+" "+student[2]));
        */
        /*
        Query q=session.createQuery("Select sum(marks) from Student s where s.marks>60");
        Long student=(Long) q.uniqueResult();
        System.out.println(student);
       	*/
        int n=60;
        Query q=session.createQuery("Select sum(marks) from Student s where s.marks> :mark");
        q.setParameter("mark", n);
        Long student=(Long) q.uniqueResult();
        System.out.println(student);
        session.getTransaction().commit();
        session.close();
    }
}
