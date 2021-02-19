package com.cg.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.entity.Employee;
import com.cg.ems.service.EmployeeSearch;

@RestController
@CrossOrigin
public class EmployeeSearchController {
	@Autowired
	EmployeeSearch employeeSearch;
	@GetMapping("/employee/find/{id}")
	public Employee findById(@PathVariable int id)
	{
		return employeeSearch.getEmployeeById(id);
	}
	@GetMapping("/employee/findAll")
	public List<Employee> findById()
	{
		return employeeSearch.getAllEmployee();
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee emp)
	{
		employeeSearch.addEmployee(emp);
		return "Employee Addedd Successfully";
				
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		return employeeSearch.removeEmployeeById(id);

				
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee emp)
	{
		employeeSearch.updateEmployee(emp);
		return "Employee Updated Successfully";
				
	}
	
}

