package com.smsgreeting.smsservice.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class SMSMessage {

	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer Id;
	
	String mobile;
	String message;
	String status;
}
