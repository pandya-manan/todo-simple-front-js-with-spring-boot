package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entity.Task;
import com.todo.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task getTaskById(Long taskId) {
		Task foundTaskById=taskRepository.findById(taskId).get();
		return foundTaskById;
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> found=taskRepository.findAll();
		return found;
	}

	@Override
	public Task updateTask(Long taskId, Task task) {
		Task foundTaskById=taskRepository.findById(taskId).get();
		foundTaskById.setTaskDescription(task.getTaskDescription());
		foundTaskById.setTaskHeadline(task.getTaskHeadline());
		return taskRepository.save(foundTaskById);
	}

	@Override
	public String deleteTask(Long taskId) {
		taskRepository.deleteById(taskId);
		return "Task with Id: "+taskId+" is deleted";
	}

}
