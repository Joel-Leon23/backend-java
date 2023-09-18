package com.springboot.backend.app.computers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Computer>> list() {
		return new ResponseEntity<>(microService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Computer> detail(@PathVariable Long id) {
		return new ResponseEntity<>(microService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<Computer> create(@RequestBody Computer computer) {
		try {
            microService.create(computer);
            return new ResponseEntity<>(computer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Computer> update(@PathVariable Long id, @RequestBody Computer computer) {
		Computer updatedComputer = microService.update(id, computer); 
		if (updatedComputer != null) {
			return new ResponseEntity<>(updatedComputer, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Computer> delete(@PathVariable Long id) {
		try {
            microService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

}
