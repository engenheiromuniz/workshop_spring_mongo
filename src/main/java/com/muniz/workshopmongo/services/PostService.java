package com.muniz.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muniz.workshopmongo.domain.Post;
import com.muniz.workshopmongo.repositories.PostRepository;
import com.muniz.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
		
	
	public Post findById(String id) {		
	    Optional<Post> obj = repository.findById(id);
	    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}
}












