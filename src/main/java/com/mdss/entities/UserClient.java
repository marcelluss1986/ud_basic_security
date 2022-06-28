package com.mdss.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_userClient")
public class UserClient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String login;
	private String password;
	private Boolean admin;
	
	public UserClient() {
		
	}

	public UserClient(Long id, String login, String password, Boolean admin) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.admin = admin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	public Boolean isAdmin() {
		return false;
	}

	public Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
