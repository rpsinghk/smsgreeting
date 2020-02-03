package com.smsgreeting.accountservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smsgreeting.accountservice.dao.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	
	List<User> findByUsername(String username);
	
	
	
	@Query("SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2")
	List<User> findByUsernameAndPassword(String username,String password);
	
	

}
