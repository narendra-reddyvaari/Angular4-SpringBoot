package com.narendra.taskmanagement.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class ToDoTask implements Serializable{
	
	
	
	private static final long serialVersionUID = 5996464030586750832L;
	public ToDoTask() {}
	public ToDoTask(Integer id, String description, Boolean completed) {
		super();
		this.id = id;
		this.description = description;
		this.completed = completed;
	}
	@Id
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String description;
	private Boolean completed;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

}
