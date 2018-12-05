package com.unicom.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicom.task.entity.TaskList;

public interface TaskListRepository extends JpaRepository<TaskList, Integer> {

}
