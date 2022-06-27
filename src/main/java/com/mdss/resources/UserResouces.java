package com.mdss.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdss.entities.User;
import com.mdss.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResouces {
	
	@Autowired
	private UserServices userService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>>findAll(){
		List<User> obj = userService.findall();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> insert(@RequestBody User obj){
		User user = userService.insert(obj);
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		userService.findById(id);
		return ResponseEntity.noContent().build();
	}
}
