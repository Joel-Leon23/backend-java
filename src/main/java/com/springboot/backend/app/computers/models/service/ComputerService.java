package com.springboot.backend.app.computers.models.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springboot.backend.app.computers.models.Computer;

public interface ComputerService {

	public List<Computer> findAll();
	
	public Computer findById(Long id);
	
	public Computer create(Computer computer);

	public Computer update(Long id, Computer computer);

	public void delete(Long id);
}
