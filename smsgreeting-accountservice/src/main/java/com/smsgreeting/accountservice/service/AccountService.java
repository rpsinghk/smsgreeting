package com.smsgreeting.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smsgreeting.accountservice.Status;
import com.smsgreeting.accountservice.dao.User;
import com.smsgreeting.accountservice.repository.UserRepository;
import com.smsgreeting.accountservice.util.RequestHelper;


@Component
public class AccountService {
	
	
	@Autowired
	UserRepository userRepository;
	
	
	public Status signUp(User user) {
		List<User> users = userRepository.findByUsername(user.getUsername());
		if(users.isEmpty()) {
			userRepository.save(user);	
			return Status.ok;
		}
		return Status.error;
	}
	
	
	
	public User login(User user) {
		List<User> users = userRepository.findByUsernameAndPassword(user.getUsername(),	user.getPassword());
		if(!users.isEmpty()) {
			user = users.get(0);
			String token = RequestHelper.tokenGenerator();
			user.setToken(token);
			userRepository.save(user);	
			return user;
		}
		return null;
	}


}
