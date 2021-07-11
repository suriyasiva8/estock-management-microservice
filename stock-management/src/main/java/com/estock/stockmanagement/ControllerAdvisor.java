package com.estock.stockmanagement;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(DuplicateKeyException.class)
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public ResponseEntity<Object> handleDuplicateException(Exception ex, WebRequest request) {
		return new ResponseEntity<>("Duplicate Key Exception",HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(Exception.class)
	@Order(Ordered.LOWEST_PRECEDENCE)
	public ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request) {
		return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
