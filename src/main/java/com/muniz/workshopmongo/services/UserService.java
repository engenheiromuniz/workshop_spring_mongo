package com.muniz.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muniz.workshopmongo.domain.User;
import com.muniz.workshopmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {		
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		// TODO Auto-generated method stub
		newObj.setName(obj.getName());
		newObj.setMail(obj.getMail());		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getMail());
	}

}












