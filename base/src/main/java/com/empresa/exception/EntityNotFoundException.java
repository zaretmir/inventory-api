package com.empresa.exception;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5067100674895732114L;
	
	public EntityNotFoundException(@SuppressWarnings("rawtypes") Class clazz) {
		super(clazz.getSimpleName() + " was not found");
	}
	
	
	// TO-DO Modificar esto?
	public EntityNotFoundException(@SuppressWarnings("rawtypes") Class clazz, Boolean isList) {
		super("No matches found for " + clazz.getSimpleName());
		
	}

}