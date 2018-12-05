package com.unicom.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unicom.task.entity.TaskList;
import com.unicom.task.service.TaskListService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TaskController {
	
	@Autowired
	private TaskListService taskService;
	
	@PostMapping("/task")
	public HttpStatus createTask(@RequestBody TaskList taskList) {
		if(taskService.createTask(taskList)) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@GetMapping("/task")
	public List<TaskList> viewAllTask(){
		return taskService.viewAllTask();
	}
	
	@PutMapping("/task")
	public HttpStatus editTask(@RequestBody TaskList taskList) {
		if(taskService.editTask(taskList)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@DeleteMapping("/task/{id}")
	public HttpStatus deleteTask(@PathVariable Integer id) {
		if(taskService.deleteTask(id)) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}

}
