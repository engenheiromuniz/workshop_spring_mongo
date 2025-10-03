package com.muniz.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.muniz.workshopmongo.domain.User;
import com.muniz.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		repository.deleteAll();
		
		User maria = new User(null,"Maria Brown", "maria@kurts.com");
		User alex  = new User(null,"Alex Green", "a.green@kurts.com");
		User bob   = new User(null,"Robert Mount", "robert.mount@kurts.com");
		
		repository.saveAll(Arrays.asList(maria,alex,bob));
		
	}

}
