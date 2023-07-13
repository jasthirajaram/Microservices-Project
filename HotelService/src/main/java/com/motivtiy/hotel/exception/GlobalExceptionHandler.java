package com.motivtiy.hotel.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@SuppressWarnings("unchecked")
	@ExceptionHandler(value = HotelNotFoundException.class)
	ResponseEntity<Map<String,Object>> notFoundException(HotelNotFoundException exception){
	Map map = new HashMap<>();
	map.put("message", exception.getMessage());
	map.put("success", true);
	map.put("status", HttpStatus.NOT_FOUND);
	return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NOT_FOUND);
	}

}
