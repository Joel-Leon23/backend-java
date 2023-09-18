package com.springboot.backend.app.computers.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "computers")
public class Computer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String processor;
	@Column(name = "graphics_card")
	private String graphicsCard;
	@Column(name = "ram_gb")
	private int ramGB;
	
	
	// Empty body for spring post
	public Computer () {
		
	}
	
	
	// getters y setters
	public String getProcessor() {
		return this.processor;
	}
	
	public void setProcessor (String processor) {
		this.processor = processor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public int getRamGB() {
		return ramGB;
	}


	public void setRamGB(int ramGB) {
		this.ramGB = ramGB;
	}


	public String getGraphicsCard() {
		return graphicsCard;
	}


	public void setGraphicsCard(String graphicsCard) {
		this.graphicsCard = graphicsCard;
	}
}
