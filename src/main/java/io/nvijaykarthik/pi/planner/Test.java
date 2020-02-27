package io.nvijaykarthik.pi.planner;

import javax.annotation.PostConstruct;

public class Test {

	private String message;
	
	@PostConstruct
	public void printMessage() {
		System.out.println(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
