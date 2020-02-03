package com.smsgreeting.accountservice.valueobject;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.smsgreeting.accountservice.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HttpMessage{
	
	@NotNull
	Status status;
	
	@NotNull
	String message;
	
	@JsonInclude(Include.NON_NULL)
	String[] ids;
	
	@JsonInclude(Include.NON_NULL)
	String token;
	
}
