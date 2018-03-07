package com.adrianosantos.cursomc.services.exceptions;

public class DataIntegrityViolationExcep extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationExcep (String msg) {
		super(msg);
		
	};

	public DataIntegrityViolationExcep (String msg, Throwable causa) {
		super(msg, causa);
		
	};
	
	
}
