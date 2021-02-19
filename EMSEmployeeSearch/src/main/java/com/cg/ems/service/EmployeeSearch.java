package com.cg.ems.service;

import java.util.List;

import com.cg.ems.entity.Employee;

public interface EmployeeSearch {
	public Employee getEmployeeById(int id);
	public String addEmployee(Employee emp);
	public Employee updateEmployee(Employee emp);
	public String removeEmployeeById(int id);
	public List<Employee> getAllEmployee();
}

