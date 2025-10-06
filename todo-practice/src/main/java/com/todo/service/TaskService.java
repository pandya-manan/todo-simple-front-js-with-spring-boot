package com.todo.service;

import java.util.List;

import com.todo.entity.Task;

public interface TaskService {

	Task saveTask(Task task);

	Task getTaskById(Long taskId);

	List<Task> getAllTasks();

	Task updateTask(Long taskId, Task task);

	String deleteTask(Long taskId);

}
