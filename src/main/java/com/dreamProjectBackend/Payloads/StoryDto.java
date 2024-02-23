package com.dreamProjectBackend.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StoryDto {
	private Integer id;
	
	private String title;
	
	private String author;
	
	private Integer rating;
	
	private String content;
}
