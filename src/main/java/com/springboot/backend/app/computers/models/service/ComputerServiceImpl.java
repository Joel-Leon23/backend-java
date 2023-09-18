package com.springboot.backend.app.computers.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.app.computers.dao.ComputerDao;
import com.springboot.backend.app.computers.models.Computer;

@Service
public class ComputerServiceImpl implements ComputerService {

	@Autowired
	private ComputerDao dao;
	@Override
	@Transactional(readOnly = true)
	public List<Computer> finAll() {
		return (List<Computer>) dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Computer findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Computer create(Computer computer) {
		return dao.save(computer);
	}

	@Override
	@Transactional
	public void update(Long id, Computer computer) {
		Computer existingComputer = dao.findById(id).orElse(null);
	    if (existingComputer != null) {
	        // Update the existing computer with the new data
	    	existingComputer.setProcessor(computer.getProcessor());
	        existingComputer.setGraphicsCard(computer.getGraphicsCard());
	        existingComputer.setRamGB(computer.getRamGB());
	        // Set other properties as needed
	        // Save the updated computer
	        dao.save(existingComputer);
	    }
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Computer existingComputer = dao.findById(id).orElse(null);
		if (existingComputer != null) {
		    dao.delete(existingComputer);
		}
	}
	
	

}
