package com.unicom.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicom.task.entity.TaskList;
import com.unicom.task.repository.TaskListRepository;

@Service
public class TaskListServiceImpl implements TaskListService{
	
	@Autowired 
	private TaskListRepository taskListRepo;

	@Override
	public boolean createTask(TaskList taskList) {
		if(taskList != null) {
			taskListRepo.save(taskList);
			return true;
		}
		return false;
	}

	@Override
	public List<TaskList> viewAllTask() {
		return taskListRepo.findAll();
	}

	@Override
	public boolean editTask(TaskList taskList) {
		if(taskListRepo.getOne(taskList.getTaskId()) != null) {
			taskListRepo.save(taskList);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteTask(Integer id) {
		if(taskListRepo.getOne(id).getTaskId()==id) {
			taskListRepo.deleteById(id);
			return true;
		}
		return false;
	}

}
