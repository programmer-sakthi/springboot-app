package com.example.SpringApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_data")
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
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public Entityclass(int empId, String empName, String empDesignation, int empAge) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.empAge = empAge;
	}
	public Entityclass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

