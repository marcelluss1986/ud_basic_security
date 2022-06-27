package com.mdss.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdss.entities.UserClient;

public interface UserClientRepository extends JpaRepository<UserClient, Long> {
	
	public Optional<UserClient> findByLogin(String login);
	
}
