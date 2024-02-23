package com.dreamProjectBackend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DreamProjectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamProjectBackendApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper(); 
	}
}
