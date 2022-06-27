package com.mdss.services.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mdss.entities.UserClient;
import com.mdss.repositories.UserClientRepository;

@Service
public class UserDetailServiceImp implements UserDetailsService {

	
	@Autowired
	private UserClientRepository userClientRepository;
	
	public UserDetailServiceImp(UserClientRepository userClientRepository) {
		this.userClientRepository = userClientRepository;
	}
	
	public UserClient save(UserClient obj) {
		UserClient userClient =  userClientRepository.save(obj);
		return userClient;	
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserClient user = userClientRepository.findByLogin(username)
		.orElseThrow(() -> new UsernameNotFoundException("User not found on database"));
		
		String[] roles = user.isAdmin() ? new String [] {"ADMIN", "USER"} : new String [] {"USER"};
		
		return User
				.builder()
				.username(user.getLogin())
				.password(user.getPassword())
				.roles(roles)
				.build();
	}
}
