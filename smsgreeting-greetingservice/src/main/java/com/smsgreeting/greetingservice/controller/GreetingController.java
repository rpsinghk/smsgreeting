package com.smsgreeting.greetingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smsgreeting.greetingservice.service.GreetingService;
import com.smsgreeting.greetingservice.vo.GreetingObject;

@RequestMapping("/greeting")
@RestController
public class GreetingController {

	@Autowired
	GreetingService greetingService;
	
	@PostMapping(path="/send")
	public void send(@RequestBody GreetingObject greetingObject) {
		greetingService.send(greetingObject);
	}

}
