package com.tiendapatito.validarpedido.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ResponseEstatusException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?>handleNosuchElement(IllegalArgumentException ex,WebRequest request){
		log.error("IllegalArgumentException: "+ex.getMessage());
		String body = ex.getMessage();
		return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.CONFLICT,request);
	}
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?>handleNosuchElement(NoSuchElementException ex,WebRequest request){
		log.error("NoSuchElementException: "+ex.getMessage());
		String body = ex.getMessage();
		return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST,request);

	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<?>handleBadCredentials(BadCredentialsException ex,WebRequest request){
		log.error("BadCredentialsException: "+ex.getMessage());
		String body = "BadCredentialsException: "+ex.getMessage();
		return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.UNAUTHORIZED,request);

	}


}
