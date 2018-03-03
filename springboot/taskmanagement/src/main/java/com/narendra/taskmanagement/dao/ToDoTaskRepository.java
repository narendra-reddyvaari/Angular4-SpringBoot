package com.narendra.taskmanagement.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.narendra.taskmanagement.model.ToDoTask;

public interface ToDoTaskRepository extends MongoRepository<ToDoTask, Integer> {

	Optional<ToDoTask> findById(Integer id);
	

}
