package com.smsgreeting.smsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smsgreeting.smsservice.dao.SMSMessage;

public interface SMSMessageRepository extends JpaRepository<SMSMessage, Integer>{

}
