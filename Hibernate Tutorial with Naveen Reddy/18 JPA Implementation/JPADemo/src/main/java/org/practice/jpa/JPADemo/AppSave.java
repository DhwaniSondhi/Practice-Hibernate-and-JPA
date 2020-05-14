package org.practice.jpa.JPADemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.practice.jpa.JPADemo.basic.Person;

public class AppSave 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("databaseLink");
        EntityManager em=emf.createEntityManager();
        Person p=new Person
        			.PersonBuilder()
        			.setId(4)
        			.setName("Dhwani")
        			.build();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        System.out.println(p);
    }
}
