package com.alkemy.modelDTO;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiErrorDTO {

	private HttpStatus status;
	private String message;
	private List<String> errors;
	
	
	public ApiErrorDTO(HttpStatus status, String message, List<String> errors) {
		
		this.status = status;
		this.message = message;
		this.errors = errors;
	}
	
}