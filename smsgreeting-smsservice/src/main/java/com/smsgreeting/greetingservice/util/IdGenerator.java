package com.smsgreeting.greetingservice.util;

import net.bytebuddy.utility.RandomString;

public class IdGenerator {
	
	public static String generateId() {
		return RandomString.make(7);
	}

}
