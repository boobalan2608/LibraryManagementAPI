package com.jsp.librarymanagement.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.librarymanagement.exceptions.IdNotFoundException;
import com.jsp.librarymanagement.exceptions.ResourceNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException exception){
		ResponseStructure<String> authorResponseStructure = new ResponseStructure<String>();
		
		authorResponseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		authorResponseStructure.setMessage("Not Found");
		authorResponseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(authorResponseStructure,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleResourceNotFoundException(ResourceNotFoundException exception){
		ResponseStructure<String> authorResponseStructure = new ResponseStructure<String>();
		authorResponseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		authorResponseStructure.setMessage("Not Found");
		authorResponseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(authorResponseStructure,HttpStatus.NOT_FOUND);
	}
}
