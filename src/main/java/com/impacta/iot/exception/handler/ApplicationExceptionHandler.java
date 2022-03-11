package com.impacta.iot.exception.handler;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.impacta.iot.exception.UserNotFoundException;
import com.impacta.iot.vo.ExceptionVO;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(Exception e, ServletWebRequest request) {
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		ExceptionVO exceptionResponse = new ExceptionVO();
		
		exceptionResponse.setTimestamp(OffsetDateTime.now());
		exceptionResponse.setDetail(e.getMessage());
		exceptionResponse.setType(request.getRequest().getRequestURI());
		
		return handleExceptionInternal(e, exceptionResponse, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> uncaughtException(Exception e, ServletWebRequest request) {
		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		ExceptionVO exceptionResponse = new ExceptionVO();
		
		exceptionResponse.setTimestamp(OffsetDateTime.now());
		exceptionResponse.setDetail(e.getMessage());
		exceptionResponse.setType(request.getRequest().getRequestURI());
		
		return handleExceptionInternal(e, exceptionResponse, new HttpHeaders(), status, request);
	}
}