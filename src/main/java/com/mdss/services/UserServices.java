package com.mdss.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdss.entities.User;
import com.mdss.repositories.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repository;
	
	
	public List<User> findall() {
		return repository.findAll();

	}
	
	public User  findById(Long id){
		Optional<User> obj =  repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj){
		User user = repository.save(obj);
		return user;
	}
	
	public User update(Long id, User obj) {
		repository.findById(obj.getId()).get();
		return obj;
	}
	
}
