package com.dreamProjectBackend.ServiceImple;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamProjectBackend.Entity.Story;
import com.dreamProjectBackend.Exceptions.ResourceNotFoundException;
import com.dreamProjectBackend.Payloads.StoryDto;
import com.dreamProjectBackend.Repository.StoryRepository;
import com.dreamProjectBackend.Service.StoryService;


@Service
public class StoryServiceImplementation implements StoryService {

	@Autowired
	ModelMapper modelMapper;
	@Autowired
	StoryRepository storyRepo;
	
	@Override
	public StoryDto createStory(StoryDto storyDto) {
		// TODO Auto-generated method stub
		
		Story story= modelMapper.map(storyDto, Story.class);
		
		Story savedStory = storyRepo.save(story);
		return (modelMapper.map(savedStory, StoryDto.class));
	}

	@Override
	public StoryDto updateStory(StoryDto storyDto, Integer storyId) {
		// TODO Auto-generated method stub
		Story story= this.storyRepo.findById(storyId)
			    .orElseThrow(() -> new ResourceNotFoundException(storyId));
		story.setTitle(storyDto.getTitle());
		story.setAuthor(storyDto.getAuthor());
		story.setRating(storyDto.getRating());
		story.setContent(storyDto.getContent());
		
		Story updatedStory= storyRepo.save(story);
		return (modelMapper.map(updatedStory, StoryDto.class));
	}

	@Override
	public StoryDto getStory(Integer storyId) {
		// TODO Auto-generated method stub
		Story story= this.storyRepo.findById(storyId)
			    .orElseThrow(() -> new ResourceNotFoundException(storyId));
		return modelMapper.map(story, StoryDto.class);
	}

	@Override
	public List<StoryDto> getAllStory() {
		// TODO Auto-generated method stub
		List<Story> stories= storyRepo.findAll();
		return stories.stream().map(i-> modelMapper.map(i, StoryDto.class)).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer storyId) {
		// TODO Auto-generated method stub
		Story story= this.storyRepo.findById(storyId)
			    .orElseThrow(() -> new ResourceNotFoundException(storyId));
		storyRepo.delete(story);

	}
	
	
	

}
