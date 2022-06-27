package com.mdss.services;

import org.springframework.stereotype.Service;

import com.mdss.dto.UserDto;
import com.mdss.entities.User;
import com.mdss.repositories.UserRepository;

@Service
public class UserAuthenticationService {
	
	private UserRepository userRepository;
	private TokenService tokenService;
	
	public UserAuthenticationService (UserRepository userRepository, TokenService tokenService) {
		this.userRepository = userRepository;
		this.tokenService = tokenService;
	}
	
	public User authenticate(UserDto loginData) {
		User user = userRepository.findByEmail(loginData.getEmail()).get();
		if(loginData.getPassword().equals(user.getPassword())) {
			String token = tokenService.generateToken(user);
			System.out.println(token);
			return user;
		}
		return null;	
	}
	
}
