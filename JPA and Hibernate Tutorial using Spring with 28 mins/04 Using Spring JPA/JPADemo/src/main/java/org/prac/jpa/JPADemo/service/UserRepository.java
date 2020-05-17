package org.prac.jpa.JPADemo.service;

import org.prac.jpa.JPADemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
