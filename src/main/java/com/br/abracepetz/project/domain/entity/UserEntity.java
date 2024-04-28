package com.br.abracepetz.project.domain.entity;

import org.springframework.beans.BeanUtils;

import com.br.abracepetz.project.domain.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "AB_USER")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String login;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;

	public UserEntity(UserDTO user) {
		BeanUtils.copyProperties(user, this);
	}

	public UserEntity() {
	}
	
	
	
	
	
	
}
