package com.tiendapatito.validarpedido.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ResponseEstatusException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?>handleNosuchElement(NoSuchElementException ex,WebRequest request){
		log.error("NoSuchElementException: "+ex.getMessage());
		String body = "No such Element Exception: "+ex.getMessage();
		return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.CONFLICT,request);

	}

}
