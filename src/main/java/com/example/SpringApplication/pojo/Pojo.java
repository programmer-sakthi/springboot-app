package com.example.SpringApplication.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pojo {
	
	private  String employeeName;
	@JsonProperty("employee_userid")
	private int employeeId;
	@JsonIgnore
	private int employeeAge;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
	public Pojo(String employeeName, int employeeId, int employeeAge) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.employeeAge = employeeAge;
	}
	
	
	
	

}
