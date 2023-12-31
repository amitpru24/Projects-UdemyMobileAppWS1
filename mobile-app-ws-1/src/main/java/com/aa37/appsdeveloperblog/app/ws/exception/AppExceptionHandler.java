package com.aa37.appsdeveloperblog.app.ws.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.appsdeveloperblog.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex,WebRequest request){
		
		String errorMessageDescription = ex.getLocalizedMessage();
		
		if(errorMessageDescription == null)
			errorMessageDescription = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(LocalDate.now(), errorMessageDescription);
		
		return new  ResponseEntity<Object>(errorMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {NullPointerException.class,UserServiceException.class})
	//public ResponseEntity<Object> handleSpecificException(NullPointerException ex,WebRequest request){
		public ResponseEntity<Object> handleSpecificException(Exception ex,WebRequest request){
		String errorMessageDescription = ex.getLocalizedMessage();
		
		if(errorMessageDescription == null)
			errorMessageDescription = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(LocalDate.now(), errorMessageDescription);
		
		return new  ResponseEntity<Object>(errorMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	/*
	 * @ExceptionHandler(value = {UserServiceException.class}) public
	 * ResponseEntity<Object> handleAnyException(UserServiceException ex,WebRequest
	 * request){
	 * 
	 * String errorMessageDescription = ex.getLocalizedMessage();
	 * 
	 * if(errorMessageDescription == null) errorMessageDescription = ex.toString();
	 * 
	 * ErrorMessage errorMessage = new ErrorMessage(LocalDate.now(),
	 * errorMessageDescription);
	 * 
	 * return new ResponseEntity<Object>(errorMessage,new
	 * HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR); }
	 */
}
