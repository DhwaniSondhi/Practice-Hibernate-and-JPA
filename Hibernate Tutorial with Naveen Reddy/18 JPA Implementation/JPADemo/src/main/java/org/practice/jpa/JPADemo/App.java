package org.practice.jpa.JPADemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.practice.jpa.JPADemo.basic.Person;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("databaseLink");
        EntityManager em=emf.createEntityManager();
        Person p=em.find(Person.class, 2);
        System.out.println(p);
    }
}
