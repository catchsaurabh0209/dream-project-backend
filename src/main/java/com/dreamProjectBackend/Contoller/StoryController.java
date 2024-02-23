package com.dreamProjectBackend.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamProjectBackend.Payloads.ApiResponse;
import com.dreamProjectBackend.Payloads.StoryDto;
import com.dreamProjectBackend.Service.StoryService;

@RestController
@RequestMapping("api/dreams")
public class StoryController {
	
	@Autowired
	StoryService storyService;
	
	@GetMapping("/")
	public ResponseEntity<List<StoryDto>> getAllStories()
	{
		return ResponseEntity.ok(storyService.getAllStory());
	}
	
	@GetMapping("/{storyId}")
	public ResponseEntity<StoryDto> getStoryById(@PathVariable Integer storyId)
	{
		return ResponseEntity.ok(storyService.getStory(storyId));
	}
	
	@PostMapping("/")
	public ResponseEntity<StoryDto> createStory(@RequestBody StoryDto storyDto)
	{
		return new ResponseEntity<StoryDto>(storyService.createStory(storyDto), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{storyId}")
	public ResponseEntity<?> deleteStories(@PathVariable Integer storyId)
	{
		storyService.delete(storyId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Story successfully deleted!!"), HttpStatus.OK);
	}
	
	@PutMapping("/{storyId}")
	public ResponseEntity<StoryDto> updateStory(@PathVariable Integer storyId, @RequestBody StoryDto storyDto)
	{
		return ResponseEntity.ok(storyService.updateStory(storyDto, storyId));
	}
}
