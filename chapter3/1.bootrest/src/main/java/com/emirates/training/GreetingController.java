package com.emirates.training;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@GetMapping("/")
	Greet greet(){
		return new Greet("Hello World!");
	}
	
}

class Greet {
	private String message;
	public Greet() {}
	public Greet(String message) {
		
		this.message = message;
	}
	
	public void setMessage(String message) {
		
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}
}
