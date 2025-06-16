package com.example.movie_rest_api.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice	
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleResourceNotFound(ResourceNotFoundException ex){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Map.of(
						"timestamp",LocalDateTime.now(),
						"status",404,
						"error","Not Found",
						"message",ex.getMessage()
						
						
				));
	}

}
