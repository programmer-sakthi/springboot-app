package com.example.SpringApplication.repo;

import java.util.List;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringApplication.entity.Entityclass;

@Repository

public interface  EmployeeRepository extends JpaRepository<Entityclass, Integer>{
	public Page<Entityclass> findAll(Pageable page);

	 List<Entityclass> findByEmpNameAndEmpId(String empName, int empId);

}
