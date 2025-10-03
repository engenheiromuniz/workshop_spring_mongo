package com.muniz.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muniz.workshopmongo.domain.User;
import com.muniz.workshopmongo.repositories.UserRepository;
import com.muniz.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();		
	}
	
	public User findById(String id) {
		// Código CORRIGIDO/SIMPLIFICADO
	    Optional<User> obj = repository.findById(id); 
	    
	    // O método orElseThrow() retorna o objeto User se ele estiver presente, 
	    // ou lança a exceção fornecida se o Optional estiver vazio.
	    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

}