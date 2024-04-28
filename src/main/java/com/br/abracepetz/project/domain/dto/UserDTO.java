package com.br.abracepetz.project.domain.dto;

import org.springframework.beans.BeanUtils;

import com.br.abracepetz.project.domain.entity.UserEntity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDTO {

	private Long id;
	
	private String name;
	
	private String login;
	
	private String cpf;
	
	private String phone;
		
	private String email;
	
	private String password;
	
	public UserDTO(UserEntity user) {
		BeanUtils.copyProperties(user, this);
	}

	public UserDTO() {
	}
	
	
}
