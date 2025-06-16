package com.example.movie_rest_api.exception;


public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
