package com.springboot.backend.app.computers.models.service;

import java.util.List;


import com.springboot.backend.app.computers.models.Computer;

public interface ComputerService {

	public List<Computer> finAll();
	
	public Computer findById(Long id);
	
	public Computer create(Computer computer);

	public void update(Long id, Computer computer);

	public void delete(Long id);
}
