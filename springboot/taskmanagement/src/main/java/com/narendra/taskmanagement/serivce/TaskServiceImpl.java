package com.narendra.taskmanagement.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narendra.taskmanagement.dao.ToDoTaskRepository;
import com.narendra.taskmanagement.model.ToDoTask;
/**
 * 
 * @author Narendra
 * This class interacts with DAO and does all crud oprations
 *
 */
@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private ToDoTaskRepository toDoTaskRepository;

	@Override
	public List<ToDoTask> findAllTasks() {

		return toDoTaskRepository.findAll();
	}

	@Override
	public ToDoTask addTask(ToDoTask toDoTask) {

		return toDoTaskRepository.save(toDoTask);
	}

	@Override
	public void updateTask(ToDoTask toDoTask) {

		toDoTaskRepository.save(toDoTask);

	}

	@Override
	public void deleteTask(Integer id) {

		toDoTaskRepository.deleteById(id);

	}

}
