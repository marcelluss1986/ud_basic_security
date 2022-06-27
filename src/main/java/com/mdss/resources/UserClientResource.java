package com.mdss.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mdss.entities.UserClient;
import com.mdss.services.imp.UserDetailServiceImp;

@RestController
@RequestMapping(value = "/userclient")
public class UserClientResource {

	@Autowired
	private UserDetailServiceImp userServiceImp;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserClientResource(UserDetailServiceImp userServiceImp, PasswordEncoder passwordEncoder) {
		super();
		this.userServiceImp = userServiceImp;
		this.passwordEncoder = passwordEncoder;
	}



	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public UserClient save(@RequestBody UserClient userClient) {
		String cripPassword = passwordEncoder.encode(userClient.getPassword());
		userClient.setPassword(cripPassword);
		return userServiceImp.save(userClient);
	}
}
