package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.Task;
import com.todo.service.TaskService;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TodoAppController {

	@Autowired
	private TaskService taskService;
	
	@PostMapping
	public ResponseEntity<Task> saveTask(@RequestBody Task task)
	{
		Task savedTask=taskService.saveTask(task);
		return ResponseEntity.status(201).body(savedTask);
	}
	
	@GetMapping("/{taskId}")
	public ResponseEntity<Task> getTaskById(@PathVariable Long taskId)
	{
		Task retrievedTask=taskService.getTaskById(taskId);
		return ResponseEntity.status(200).body(retrievedTask);
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> getTasks()
	{
		List<Task> tasks=taskService.getAllTasks();
		return ResponseEntity.status(200).body(tasks);
	}
	
	@PutMapping("/{taskId}")
	public ResponseEntity<Task> updateExistingTask(@PathVariable Long taskId, @RequestBody Task task)
	{
		Task updatedTask=taskService.updateTask(taskId,task);
		return ResponseEntity.status(200).body(updatedTask);
	}
	
	@DeleteMapping("/{taskId}")
	public ResponseEntity<String> deleteTask(@PathVariable Long taskId)
	{
		String deleted=taskService.deleteTask(taskId);
		return ResponseEntity.status(204).body(deleted);
	}
	
	
}
