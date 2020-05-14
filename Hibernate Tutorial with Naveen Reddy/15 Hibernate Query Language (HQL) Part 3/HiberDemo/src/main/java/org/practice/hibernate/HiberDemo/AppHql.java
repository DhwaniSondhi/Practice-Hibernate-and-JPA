package org.practice.hibernate.HiberDemo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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
        
        SQLQuery q1=session.createSQLQuery("Select name,marks from student where marks>60");
        q1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<Object> students=q1.list();
        students.forEach(student->{
        	Map studentMap=(Map) student;
        	System.out.println(studentMap.get("name")+"  "+studentMap.get("marks"));
        });
        
        session.getTransaction().commit();
        session.close();
    }
}
