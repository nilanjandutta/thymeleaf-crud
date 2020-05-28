package com.nilan.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nilan.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	//load employee data
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void LoadData() {
		
		//create employee
		Employee emp1 = new Employee(1,"Sid","Dutta","siddutta@gmail.com");
		Employee emp2 = new Employee(2,"Kat","Dutta","katdutta@gmail.com");
		Employee emp3 = new Employee(3,"Jisu","Dutta","nilandutta@gmail.com");
		
		//create list
		
		theEmployees = new ArrayList<>();
		
		//add to the list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
		
	}
	
	//add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
	

}
