package com.example.SpringApplication.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.SpringApplication.entity.Entityclass;
import com.example.SpringApplication.pojo.Pojo;
import com.example.SpringApplication.repo.EmployeeRepository;

@Service
public class Serviceclass {
	@Autowired
	EmployeeRepository repo;
	
	@Value("${api.key}")
	
	String apikey;
	public Pojo fetchPojoDetails() {
		return new Pojo("sam",12,31);
	}
	
	
	public String fetchWeatherData(String city) {
		
		String url =UriComponentsBuilder.fromUriString("https://api.openweathermap.org/data/2.5/weather")
				.queryParam("q", city)
				.queryParam("appid", apikey)
				.build()
				.toUriString();
		
		RestTemplate rest = new RestTemplate();
		
		return rest.getForObject(url, String.class);
		
	}
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/employee_details";
		String username = "root";
		String password ="sachit06";
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			 if(con!=null) {
				 System.out.println("Connection established sucessfully");
			 }
			 else {
				 System.out.println("Failed to connect db");
			 
			 }
		}
			 catch(SQLException exp) {
				 System.out.println("connection failed"+exp.getMessage());
			 }
			 
		
		}
	
	public List<Entityclass> fetchempdata(){
	return repo.findAll();
	}
}

		
	


