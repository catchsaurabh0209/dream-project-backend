package com.dreamProjectBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dreamProjectBackend.Entity.Story;

public interface StoryRepository extends JpaRepository<Story, Integer>{

}
