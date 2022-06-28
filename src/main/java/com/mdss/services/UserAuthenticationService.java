package com.mdss.services;

import org.springframework.stereotype.Service;

import com.mdss.dto.UserDto;
import com.mdss.entities.UserClient;
import com.mdss.repositories.UserClientRepository;

@Service
public class UserAuthenticationService {
	
	private UserClientRepository userClientRepository;
	private JwtService tokenService;
	
	public UserAuthenticationService (UserClientRepository userClientRepository, JwtService tokenService) {
		this.userClientRepository = userClientRepository;
		this.tokenService = tokenService;
	}
	
	public UserClient authenticate(UserDto loginData) {
		UserClient user = userClientRepository.findByLogin(loginData.getEmail()).get();
		if(loginData.getPassword().equals(user.getPassword())) {
			String token = tokenService.generateToken(user);
			System.out.println(token);
			return user;
		}
		return null;	
	}
	
}
