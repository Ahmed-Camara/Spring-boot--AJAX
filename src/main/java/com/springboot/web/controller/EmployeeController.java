package com.springboot.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.web.entity.Employee;
import com.springboot.web.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@GetMapping("/")
	public String showPage(Model model) {
		
		List<Employee> employees = 
				employeeRepository.findAll();

		model.addAttribute("data",employees);
		
		return "index";
	}
	
	@PostMapping("/save")
	public String save(Employee employee) {
		
		employeeRepository.save(employee);
		
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id) {
		
		employeeRepository.deleteById(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/find")
	@ResponseBody
	public Employee find(@RequestParam int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null;
		
		if(result.isPresent()) {
			
			employee = result.get();
		}
		
		return employee;
	}
}
