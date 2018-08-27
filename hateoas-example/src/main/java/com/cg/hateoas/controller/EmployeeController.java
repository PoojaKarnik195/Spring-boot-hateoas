package com.cg.hateoas.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hateoas.pojo.Employee;
import com.cg.hateoas.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeService;
	
	@RequestMapping(value="/employee/{start}/{count}", method=RequestMethod.GET)
	public Resource<List<Employee>> getEmployeeByPage(@PathVariable("start") int start,
			@PathVariable("count") int count){
		List<Employee> tempEmployees=employeeService.viewAllEmployees();
		List<Employee> employees=new ArrayList<>();
		
		for(int i=start;i<start+count;i++) {
			employees.add(tempEmployees.get(i-1));
		}
		
		Link nextLink=linkTo(methodOn(this.getClass())
				.getEmployeeByPage(start+count,count)).withRel("nextLink");
		
		Link previousLink=linkTo(methodOn(this.getClass())
				.getEmployeeByPage(start-count>=0?start-count:1,count)).withRel("previousLink");
		
		Resource<List<Employee>> resource = new Resource<>(employees,nextLink,previousLink);
		
		return resource;
	}
	
	@RequestMapping(value="/employee/add", method=RequestMethod.POST, consumes="application/json")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addNewEmployee(employee);
	}
	
	@RequestMapping(value="/employees", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public Collection<Employee> viewAllEmployee(){
		return employeeService.viewAllEmployees();
	}
	
	@RequestMapping(value="/employee/update", method=RequestMethod.PUT, consumes="application/json")
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
	}
	
	@RequestMapping(value="/employee/delete", method=RequestMethod.DELETE)
	public void deleteEmployee(int id) {
		employeeService.deleteEmployee(id);
	}
}
