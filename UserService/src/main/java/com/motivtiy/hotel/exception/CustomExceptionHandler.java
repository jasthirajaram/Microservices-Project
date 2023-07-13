package com.motivtiy.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ErrorDetail> userNotFoundHandler(UserNotFoundException exception){
		ErrorDetail detail = ErrorDetail.builder()
				.message(exception.getMessage())
				.success(true)
				.httpStatus(HttpStatus.NOT_FOUND)
				.build();
		return new ResponseEntity<ErrorDetail>(detail, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorDetail> globalExceptionHandler(Exception exception){
		ErrorDetail detail = ErrorDetail.builder()
				.message(exception.getMessage())
				.success(true)
				.httpStatus(HttpStatus.NOT_FOUND)
				.build();
		return new ResponseEntity<ErrorDetail>(detail, HttpStatus.NOT_FOUND);
	}

}
