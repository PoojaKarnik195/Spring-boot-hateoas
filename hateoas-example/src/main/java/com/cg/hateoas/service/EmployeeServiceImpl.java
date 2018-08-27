package com.cg.hateoas.service;

import java.util.List;
import org.springframework.stereotype.Component;

import com.cg.hateoas.dao.EmployeeDao;
import com.cg.hateoas.pojo.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao dao;

	@Override
	public List<Employee> viewAllEmployees() {
		return dao.findAll();
	}

	@Override
	public void addNewEmployee(Employee employee) {
		dao.save(employee);

	}

	@Override
	public void updateEmployee(Employee employee) {
		dao.save(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		dao.deleteById(id);
	}
}
