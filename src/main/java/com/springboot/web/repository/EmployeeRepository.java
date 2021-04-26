package com.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
