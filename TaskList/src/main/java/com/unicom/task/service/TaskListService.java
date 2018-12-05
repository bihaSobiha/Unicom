package com.unicom.task.service;

import java.util.List;

import com.unicom.task.entity.TaskList;

public interface TaskListService {
	boolean createTask(TaskList taskList);
	List<TaskList> viewAllTask();
	boolean editTask(TaskList taskList);
	boolean deleteTask(Integer id);

}
