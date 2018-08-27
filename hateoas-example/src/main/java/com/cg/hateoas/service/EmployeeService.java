package com.cg.hateoas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hateoas.pojo.Employee;

@Service
public interface EmployeeService {

	public abstract List<Employee> viewAllEmployees();

	public abstract void addNewEmployee(Employee employee);

	public abstract void updateEmployee(Employee employee);

	public abstract void deleteEmployee(int id);
}
