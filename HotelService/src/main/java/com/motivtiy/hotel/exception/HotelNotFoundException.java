package com.motivtiy.hotel.exception;

public class HotelNotFoundException extends RuntimeException {

	private String message;
	
	public HotelNotFoundException()
	{
		super("Hotel not Found ");
	}

	public HotelNotFoundException(String message) {
		this.message = message;
		System.out.println(message);
	}
	
	
}
