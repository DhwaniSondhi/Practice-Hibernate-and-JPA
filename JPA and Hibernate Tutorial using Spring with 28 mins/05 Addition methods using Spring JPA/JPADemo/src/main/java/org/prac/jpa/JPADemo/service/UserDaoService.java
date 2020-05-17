package org.prac.jpa.JPADemo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.prac.jpa.JPADemo.entity.User;
import org.springframework.stereotype.Repository;

//something that interact with database
@Repository
@Transactional
public class UserDaoService {

	@PersistenceContext
	private EntityManager em;
	
	public long insertUser(User user) {
		
		em.persist(user);
		return user.getId();
	}
	
}
