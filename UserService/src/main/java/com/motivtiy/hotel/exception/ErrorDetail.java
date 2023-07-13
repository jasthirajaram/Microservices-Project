package com.motivtiy.hotel.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDetail {

	private String message;
	private Boolean success;
	private HttpStatus httpStatus;
	
	
}
