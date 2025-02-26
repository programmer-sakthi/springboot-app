package com.example.SpringApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringApplication.entity.Entityclass;
import com.example.SpringApplication.pojo.Pojo;
import com.example.SpringApplication.service.Serviceclass;

@RestController
public class Controller_class {
	@Autowired
	Serviceclass service;
	
	@Value("${spring.version}")
	String version;
	
	@GetMapping("/fetchname")
	public String fetchName() {
		return "Welcome to IT-C" ;
	}
	
	
	@GetMapping("/fetchemployeedetails")
	public Pojo fetchEmployeeDetails() {
		return new Pojo("Sam",1159,20);
		
	}
	
	@GetMapping("/fetchdetails")
	public Pojo fetchDetails() {
		return service.fetchPojoDetails();
	}
	
	@GetMapping("/version")
	public String fetchVersion() {
		return version;
		
	}
	
	@GetMapping("/fetchweatherdetails")
	public String fetchweatherdetails(@RequestParam String city) {
		return service.fetchWeatherData(city);
		
	}
	
	@GetMapping("/fetchempdata")
	public List<Entityclass> fetchempdata(){
	return service.fetchempdata();
	}
	@PostMapping("/insertdata")
	public  Entityclass insertEmployeeDetails(@RequestBody Entityclass data ){
			return service.insertData(data);
	}
	
	@DeleteMapping("/deleterecordsbyid/{empId}")
	public String deleterecordById(@PathVariable int empId) {
		return service.deleteRecords(empId);
		
		
	}
	@PutMapping("/updatedata/{empId}")
	public String updateExistingRecords(@PathVariable int empId,@RequestBody Entityclass data) {
		return service.updateRecords(empId,data);
	}
	@GetMapping ("/pagiation")
	public List<Entityclass> fetchPageDetails(@RequestParam int pageno,@RequestParam int pagesize, @RequestParam String empnamesort){
	return service.fetchPage(pageno,pagesize,empnamesort);
	}
	@GetMapping("/and")
	public List<Entityclass> andQuery(@RequestParam int empId,@RequestParam String empName){
	return service.fetchAndRecords(empId,empName);
	}


}
