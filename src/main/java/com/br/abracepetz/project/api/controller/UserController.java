package com.br.abracepetz.project.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.abracepetz.project.domain.dto.UserDTO;
import com.br.abracepetz.project.domain.service.RegisterUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	

	
	@Autowired
	private RegisterUserService registerUserService;
	
	@GetMapping
	public List<UserDTO> listAll(){
		return registerUserService.listAll();
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long userId){
		UserDTO userDTO = registerUserService.findById(userId);
		
		if (userDTO != null) {
			return ResponseEntity.ok(userDTO);
		}
		
		return ResponseEntity.notFound().build();
		
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody UserDTO userDTO) {
		registerUserService.create(userDTO);
	}
	
	
	@PutMapping
	public ResponseEntity<UserDTO> alter(@RequestBody UserDTO userDto){
		UserDTO currentUser = registerUserService.alter(userDto);
		return ResponseEntity.ok(currentUser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> delete(@PathVariable("userId") Long id){
		registerUserService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	

}
