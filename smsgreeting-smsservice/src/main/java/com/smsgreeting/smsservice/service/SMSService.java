package com.smsgreeting.smsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.smsgreeting.greetingservice.vo.GreetingObject;
import com.smsgreeting.smsservice.dao.SMSMessage;
import com.smsgreeting.smsservice.repository.SMSMessageRepository;

@Component
@KafkaListener(topics = "greetingqq")
public class SMSService {

	@Autowired
	SMSMessageRepository smsRepository;

	@KafkaHandler
	public void sendSMS(@Payload GreetingObject.Greeting go) {
		System.out.println(go);
		System.out.println("");
		SMSMessage message = new SMSMessage();
		message.setMessage(go.getMessage());
		message.setMobile(go.getMobile());
		message.setStatus("Sent");
		smsRepository.save(message);
	}

}
