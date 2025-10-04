package com.muniz.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.muniz.workshopmongo.domain.Post;
import com.muniz.workshopmongo.domain.User;
import com.muniz.workshopmongo.repositories.PostRepository;
import com.muniz.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User mary  = new User(null,"Maria Brown", "maria@kurts.com");
		User alex  = new User(null,"Alex Green", "a.green@kurts.com");
		User bob   = new User(null,"Robert Mount", "robert.mount@kurts.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2025"), "Partiu Viagem!!!", "Vou viajar para São Paulo, abraços!!!",  mary);
		Post post2 = new Post(null, sdf.parse("23/03/2025"), "Bom dia...", "Acordei muito feliz hoje!",  mary);
		
		userRepository.saveAll(Arrays.asList(mary,alex,bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
