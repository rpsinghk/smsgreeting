package com.smsgreeting.greetingservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.smsgreeting.greetingservice.vo.GreetingObject;

@Component
public class GreetingService {
	
	@Autowired
	KafkaTemplate<String, GreetingObject.Greeting> kafkaTemplate;
	
	public void send(GreetingObject greetingObject) {
		try {
			List<String> ids = new ArrayList<>();
			greetingObject.greetings().stream().forEach(greeting ->{
				kafkaTemplate.send("greetingqq", greeting);
				ids.add(((GreetingObject.Greeting)greeting).getId());
			});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
