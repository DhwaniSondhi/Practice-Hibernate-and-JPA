package org.prac.jpa.JPADemo.service;

import org.prac.jpa.JPADemo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner{

	@Autowired
	UserDaoService userDaoService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	
	@Override
	public void run(String... args) throws Exception {
		User user=new User
				.UserBuilder()
				.setName("Dhwani")
				.setRole("Admin")
				.build();
		long insert=userDaoService.insertUser(user);
		LOGGER.info("{}",user);
	}

}
