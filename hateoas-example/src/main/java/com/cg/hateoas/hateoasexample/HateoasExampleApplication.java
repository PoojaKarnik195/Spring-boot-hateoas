package com.cg.hateoas.hateoasexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cg.hateoas.dao.EmployeeDao;
import com.cg.hateoas.pojo.Employee;

@SpringBootApplication
public class HateoasExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HateoasExampleApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(EmployeeDao dao) {
		return (args)->{
			dao.save(new Employee(1,"Pooja","Karnik"));
			dao.save(new Employee(2,"Shraddha","Kapoor"));
			dao.save(new Employee(3,"Anand","Hegde"));
			dao.save(new Employee(4,"Priyanka","Deshpande"));
			dao.save(new Employee(5,"Mouli","Khan"));
			dao.save(new Employee(6,"Manish","Kumar"));
			dao.save(new Employee(7,"Poornima","Achar"));
			dao.save(new Employee(8,"Sagar","Mehta"));
			dao.save(new Employee(9,"Harish","K"));
			dao.save(new Employee(10,"Kiran","M"));
		};
	}
}
