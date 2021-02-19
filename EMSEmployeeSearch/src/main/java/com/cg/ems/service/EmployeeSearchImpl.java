package com.cg.ems.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.entity.Employee;
import com.cg.ems.repository.EmployeeRepository;
@Service
public class EmployeeSearchImpl implements EmployeeSearch {
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}
	@Override
	public String addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employeeRepository.save(emp);
		return "New Employee Added";
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		//IF EMPLOYEE WILL HAVE NEW DATA OTHER THAN PK 
		Employee updateEmployee=emp;
		return employeeRepository.save(updateEmployee);
	}

	@Override
	public String removeEmployeeById(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		return "Employee with Id"+id+"deleted";
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

}

