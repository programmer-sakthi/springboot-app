package com.example.SpringApplication.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Pageable;

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
		return new Pojo("sam", 12, 31);
	}

	public String fetchWeatherData(String city) {

		String url = UriComponentsBuilder.fromUriString("https://api.openweathermap.org/data/2.5/weather")
				.queryParam("q", city).queryParam("appid", apikey).build().toUriString();

		RestTemplate rest = new RestTemplate();

		return rest.getForObject(url, String.class);

	}

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/employee_details";
		String username = "root";
		String password = "sachit06";
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			if (con != null) {
				System.out.println("Connection established sucessfully");
			} else {
				System.out.println("Failed to connect db");

			}
		} catch (SQLException exp) {
			System.out.println("connection failed" + exp.getMessage());
		}

	}

	public List<Entityclass> fetchempdata() {
		return repo.findAll();
	}

	public Entityclass insertData(Entityclass data) {
		return repo.save(data);
	}

	public String deleteRecords(int empId) {
		if (repo.existsById(empId)) {
			repo.deleteById(empId);
			return empId + "Data deleted Successfully";

		} else {
			return empId + "Data not found";
		}
	}

	public String updateRecords(int empId,Entityclass data) {
		if (repo.existsById(empId)) {
			repo.save(data);
			return empId+"Data updated successfully";

		}else {
			return empId+"Data not found";
		}
	}

	public List<Entityclass> fetchPage(int pageno, int pagesize, String empnamesort) {
		Pageable  page = PageRequest.of(pageno, pagesize, Sort.by(empnamesort).ascending());
		return repo.findAll(page).getContent();
	}

	public List<Entityclass> fetchAndRecords(int empId, String empName) {
		
		return repo.findByEmpNameAndEmpId(empName,empId);
	}

	
}
