package com.narendra.taskmanagement.serivce;

import java.util.List;

import com.narendra.taskmanagement.model.ToDoTask;

public interface TaskService {
	
	public List<ToDoTask> findAllTasks();
	
	public ToDoTask addTask(ToDoTask toDoTask);
	
	public ToDoTask updateTask(ToDoTask toDoTask);
	
	public void deleteTask(Integer id);

}
