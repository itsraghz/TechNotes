package com.raghsonline.springboot.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@GetMapping("/")
	public String showMsg() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtFormat = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		String nowStr = now.format(dtFormat);
		System.out.println("Request Received for '/' at : " + nowStr);
		return "Welcome to Spring Boot - in Docker! Present Server Time : " + nowStr;
	}

}
