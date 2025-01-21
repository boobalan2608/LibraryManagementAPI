package com.jsp.librarymanagement.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	
	public ResourceNotFoundException(){
		
	}
	public ResourceNotFoundException(String msg){
		super(msg);
	}

}
