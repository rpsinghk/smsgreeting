package com.smsgreeting.smsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;


@ComponentScan
@SpringBootApplication
public class SMSServiceApplication {
	
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SMSServiceApplication.class, args);
		
	}

}
