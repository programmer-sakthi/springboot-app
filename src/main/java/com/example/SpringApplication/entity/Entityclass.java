package com.example.SpringApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="employee_data")

@Data



public class Entityclass {
	
	
	@Id
	@Column(name="empId")
	private int empId;
	@Column(name="empName")
	private String empName;
	@Column(name="empDesignation")
	private String empDesignation;
	@Column(name="empAge")
	private int empAge;
	
	public Entityclass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

