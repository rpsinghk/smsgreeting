package com.smsgreeting.greetingservice.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.smsgreeting.greetingservice.util.IdGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter
@NoArgsConstructor
public class GreetingObject{
	
	private String mobiles;
	
	private String message;
	
	
	public List<String> mobiles() {
		return Arrays.asList(mobiles.split(","));
	}

	public List<Greeting> greetings(){
		  List<Greeting> grt = mobiles().stream().map(x->new Greeting(IdGenerator.generateId(),x,message)).collect(Collectors.toCollection(ArrayList::new));
		return grt;
	}
	
	@Setter @Getter
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	public static class Greeting{
		String id;
		
		String mobile;
		
		String message;
		
		
	}
	
}
