package com.lucaspxt.simulador.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<SimuladorResultError> notValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		SimuladorResultError err = new SimuladorResultError();
		
		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			err.addErrors(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(err);
	}
}
