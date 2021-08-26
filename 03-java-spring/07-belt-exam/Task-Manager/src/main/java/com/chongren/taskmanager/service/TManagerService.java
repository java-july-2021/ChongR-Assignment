package com.chongren.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chongren.taskmanager.model.Task;
import com.chongren.taskmanager.repository.TaskRepository;
import com.chongren.taskmanager.repository.UserRepository;
@Service
public class TManagerService {
	
	@Autowired
	public TaskRepository tRepo;
	
	@Autowired
	public UserRepository uRepo;
	
	//================= Task ===================//
	//Create
	public Task createTask(Task newTask) {
		return this.tRepo.save(newTask);
	}
	
	//Read
	public Task findSingleTask(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	//Update
	public Task updateTask(Task task) {
		return this.tRepo.save(task);
	}
	
	//Delete
	public void deletaTask(Long id) {
		this.tRepo.deleteById(id);
	}
	
	//Show All Task
	public List<Task> showAllTask(){
		return this.tRepo.findAll();
	}
	
	
	
	
}
