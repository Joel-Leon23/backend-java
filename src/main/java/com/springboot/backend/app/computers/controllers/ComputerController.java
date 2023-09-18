package com.springboot.backend.app.computers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.app.computers.models.Computer;
import com.springboot.backend.app.computers.models.service.ComputerService;

@RestController
@RequestMapping("/computers")
public class ComputerController {
	
	@Autowired
	private ComputerService microService;
	
	@GetMapping
	public List<Computer> list() {
		return microService.finAll();
	}
	
	@GetMapping("/{id}")
	public Computer detail(@PathVariable Long id) {
		return microService.findById(id);
	}
	
	@PostMapping(consumes="application/json", produces="application/json")
	public Computer create(@RequestBody Computer computer) {
		return microService.create(computer);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @RequestBody Computer computer) {
		microService.update(id, computer);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		microService.delete(id);
	}

}
