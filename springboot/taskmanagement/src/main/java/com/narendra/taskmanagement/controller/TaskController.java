package com.narendra.taskmanagement.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narendra.taskmanagement.model.ToDoTask;
import com.narendra.taskmanagement.serivce.TaskService;


@RestController
@RequestMapping("/taskmanagement")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*") // this is set to * to post requests through postman as well.
public class TaskController {
	
	
	@Autowired
	private TaskService taskService;
	
	
	//get all tasks
	@GetMapping("/todo")
	public  List<ToDoTask> findalltoDo(){
		
		return taskService.findAllTasks();
		
	}
	
	//save task
	@PostMapping("/todo")
	public ToDoTask addTodo(@RequestBody ToDoTask toDoTask){
		
		Random random = new Random();
		Integer Id = random.nextInt();
		toDoTask.setId(Id);
		toDoTask.setCompleted(false);
		return taskService.addTask(toDoTask);
		
	}
	
	//update task
	@PutMapping("/todo")
	public ToDoTask updateTod(@RequestBody ToDoTask toDoTask) {
		return taskService.updateTask(toDoTask);
		
	}
	
	//delete task
	@DeleteMapping("/todo/{id}")
	public void deletTodo(@PathVariable("id") Integer id) {
		taskService.deleteTask(id);
		
	}
	
	//to initialize tasks for testing. This end point is called from front end
	@GetMapping("/addtodotasks")
	public String addtodotasks() {
		
		Random random = new Random();
		ToDoTask task1 = new ToDoTask(random.nextInt(), "description1", false);
		ToDoTask task2 = new ToDoTask(random.nextInt(), "description2", false);
		ToDoTask task3 = new ToDoTask(random.nextInt(), "description3", false);
		ToDoTask task4 = new ToDoTask(random.nextInt(), "description4", false);
		ToDoTask task5 = new ToDoTask(random.nextInt(), "description5", false);
		
		taskService.addTask(task1);
		taskService.addTask(task2);
		taskService.addTask(task3);
		taskService.addTask(task4);
		taskService.addTask(task5);
		
		return "success";
		
	}
	
}
