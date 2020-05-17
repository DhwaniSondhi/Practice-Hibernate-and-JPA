package org.prac.jpa.JPADemo.service;

import java.util.*;

import org.prac.jpa.JPADemo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user=new User
					.UserBuilder()
					.setName("Jill")
					.setRole("User")
					.build();
		userRepository.save(user);
		LOGGER.info("Saved user: {}",user);
		Optional<User> getUser=userRepository.findById(user.getId());		
		LOGGER.info("Get user: {}",getUser.get());
		List<User> userList=userRepository.findAll();
		LOGGER.info("All users: {}",userList);
		long count=userRepository.count();
		LOGGER.info("All users count: {}",count);
	}

}
