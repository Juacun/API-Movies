package com.alkemy.exception;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.alkemy.modelDTO.ApiErrorDTO;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {ParamNotFound.class})
	protected ResponseEntity<Object> handleParamNotFound(RuntimeException ex, WebRequest request) {
		
		ApiErrorDTO errorDTO =  new ApiErrorDTO(
				HttpStatus.BAD_REQUEST,
				ex.getMessage(),
				Arrays.asList("Param Not Found")
		);
		return handleExceptionInternal(ex, errorDTO, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
}