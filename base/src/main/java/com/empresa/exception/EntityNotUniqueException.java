package com.empresa.exception;

import java.lang.reflect.Field;

public class EntityNotUniqueException extends RuntimeException {

	private static final long serialVersionUID = 381135412796272007L;
	
	
	public EntityNotUniqueException(Object entity, Field duplicateField) {
		super(entity.getClass().getSimpleName() + " with this " +  duplicateField.getName() + " already exists");
	}
	
	
	public EntityNotUniqueException(Object entity) {
		super(entity.getClass().getSimpleName() + " already exists");
	}
	

}
