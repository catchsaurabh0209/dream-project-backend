package com.dreamProjectBackend.Service;

import java.util.List;

import com.dreamProjectBackend.Payloads.StoryDto;

public interface StoryService{
	
	StoryDto createStory(StoryDto  storyDto);
	
	StoryDto updateStory(StoryDto storyDto, Integer storyId);
	
	StoryDto getStory(Integer storyId);
	
	List<StoryDto> getAllStory();
	
	void delete(Integer storyId);

}
