package com.motivtiy.hotel.exception;

public class UserNotFoundException extends RuntimeException {

	private String message;
	public UserNotFoundException() {
		super("User is not available");
	}
	public UserNotFoundException(String message) {
		super(message);
	}
	
	
}
