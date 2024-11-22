package com.bank.manage.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import ch.qos.logback.core.spi.ErrorCodes;

@ControllerAdvice
public class GlobalExceptionHandler {

// handle specific exc
	@ExceptionHandler(AccountException.class)
	public ResponseEntity<ErrorDetails> handleAccountException(AccountException exception, WebRequest webrequest) {
		
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), 
				exception.getMessage(),
				webrequest.getDescription(false),
				 " Account not found");
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}

	// handle generic exc
	@ExceptionHandler(Exception.class)
     public ResponseEntity<ErrorDetails> handleGenericException(AccountException exception, WebRequest webrequest) {
		
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), 
				exception.getMessage(),
				webrequest.getDescription(false),
				 "INTERNAL_SERVER_ERROR");
		return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
