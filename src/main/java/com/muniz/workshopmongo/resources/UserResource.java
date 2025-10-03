package com.muniz.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muniz.workshopmongo.domain.User;
import com.muniz.workshopmongo.dto.UserDTO;
import com.muniz.workshopmongo.services.UserService;

// REMOVA: import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod; // REMOVER ESTA LINHA!

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listDto);		
	}

    // CORRIGIDO: Removido o 'method=RequestMethod.GET' e a importação incorreta
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = service.findById(id); 
		return ResponseEntity.ok().body(new UserDTO(obj));		
	}	
}