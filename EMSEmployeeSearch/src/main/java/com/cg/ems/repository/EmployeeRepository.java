package com.cg.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
