package com.smsgreeting.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smsgreeting.accountservice.Status;
import com.smsgreeting.accountservice.dao.User;
import com.smsgreeting.accountservice.service.AccountService;
import com.smsgreeting.accountservice.util.RequestHelper;
import com.smsgreeting.accountservice.valueobject.HttpMessage;

@RequestMapping("/account")
@RestController
public class AccountServiceController {
	
	
	@Autowired
	AccountService accountService;
	
	@PostMapping(path = "sign-up", consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpMessage> hello(@RequestBody User user) {
		HttpMessage hm = null;
		Status status = null;
		try {
		status = accountService.signUp(user);
		if(Status.error.equals(status)) {
			hm = HttpMessage.builder().status(status).message("Account Already Exist").build();	
		}else {
			hm = HttpMessage.builder().status(status).message("Account Created").build();
		}
		
		}catch(Exception exception){
			exception.printStackTrace();
			hm = HttpMessage.builder().status(Status.error).message("Invalid Request").build();
			return ResponseEntity.ok(hm);

		}
		return ResponseEntity.ok(hm);
	}
	
	
	
	@PostMapping(path = "sign-in", consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpMessage> signIn(@RequestBody User user) {
		HttpMessage hm = null;
		User users = null;
		try {
			users = accountService.login(user);
		if(users == null) {
			hm = HttpMessage.builder().status(Status.error).message("Invalid Request").build();
			return ResponseEntity.ok(hm);
		}
		hm = HttpMessage.builder().status(Status.ok).message("Sign-in Successful").build();
		hm.setToken(users.getToken());
		RequestHelper.storeCookie("Token",users.getToken());
		}catch(Exception exception){
			exception.printStackTrace();
			hm = HttpMessage.builder().status(Status.error).message("Invalid Request").build();
			return ResponseEntity.ok(hm);

		}
		return ResponseEntity.ok(hm);
	}

}
