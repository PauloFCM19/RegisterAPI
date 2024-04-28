package com.br.abracepetz.project.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.abracepetz.project.domain.dto.UserDTO;
import com.br.abracepetz.project.domain.entity.UserEntity;
import com.br.abracepetz.project.domain.repository.UserRepository;

@Service
public class RegisterUserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO> listAll(){
		List<UserEntity> users = userRepository.findAll();
		return users.stream().map(UserDTO::new).toList();
	}
	
	public void create(UserDTO user) {
		UserEntity userEntity = new UserEntity(user);
		userRepository.save(userEntity);
	}
	
	public UserDTO alter(UserDTO user){
		UserEntity userEntity = new UserEntity(user);
		return new UserDTO(userRepository.save(userEntity));
	}
	
	public void delete(Long id) {
		UserEntity user = userRepository.findById(id).get();
		userRepository.delete(user);
	}
	
	public UserDTO findById(Long id) {
		return new UserDTO(userRepository.findById(id).get());
	}
}
