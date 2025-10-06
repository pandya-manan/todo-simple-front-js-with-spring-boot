package com.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long taskId;
	
	@Column(name="task_headline",nullable=false)
	private String taskHeadline;
	
	@Column(name="task_description",nullable=false)
	private String taskDescription;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskHeadline() {
		return taskHeadline;
	}

	public void setTaskHeadline(String taskHeadline) {
		this.taskHeadline = taskHeadline;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Task(Long taskId, String taskHeadline, String taskDescription) {
		super();
		this.taskId = taskId;
		this.taskHeadline = taskHeadline;
		this.taskDescription = taskDescription;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
