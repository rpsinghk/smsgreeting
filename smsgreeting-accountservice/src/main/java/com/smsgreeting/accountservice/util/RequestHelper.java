package com.smsgreeting.accountservice.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import net.bytebuddy.utility.RandomString;

public class RequestHelper {
	
	public static String tokenGenerator() {
		return RandomString.make(7);
	}
	
	
	
	public static void storeCookie(String cookieName, String cookieValue) {
		
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletResponse response = ((ServletRequestAttributes)requestAttributes).getResponse();
		
		Cookie ck= new Cookie(cookieName,cookieValue);
		response.addCookie(ck);
	}

}
