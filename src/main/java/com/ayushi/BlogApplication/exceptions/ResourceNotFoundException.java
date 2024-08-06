package com.ayushi.BlogApplication.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{
	
	private String ResourceName;
	private String FieldName;
	private Integer FieldValue;
	
	public ResourceNotFoundException(String ResourceName, String FieldName, Integer FieldValue)
	{
		super(String.format("%s not found with %s : %s", ResourceName, FieldName, FieldValue));
		this.ResourceName=ResourceName;
		this.FieldName=FieldName;
		this.FieldValue=FieldValue;
		}

}
