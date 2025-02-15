package com.example.SpringApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringApplication.entity.Entityclass;

@Repository

public interface  EmployeeRepository extends JpaRepository<Entityclass, Integer>{

}
