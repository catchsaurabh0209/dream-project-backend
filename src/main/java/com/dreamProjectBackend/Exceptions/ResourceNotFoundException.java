package com.dreamProjectBackend.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
	
	private Integer storyId;
	public ResourceNotFoundException(Integer storyId)
	{
		super(String.format("Story with story id "+storyId+" is not present"));
		this.storyId=storyId;
	}
}
