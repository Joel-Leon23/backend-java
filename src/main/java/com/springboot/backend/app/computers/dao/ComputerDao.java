package com.springboot.backend.app.computers.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.app.computers.models.Computer;

public interface ComputerDao extends CrudRepository<Computer, Long> {

}
