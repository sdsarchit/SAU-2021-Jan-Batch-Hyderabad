package com.asr.main.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import com.asr.main.model.Employee;
import com.asr.main.service.EmployeeService;
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {
	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@InjectMocks
	EmployeeController employeeController;
	@Mock
	EmployeeService employeeService;
	@Test
	void testCreateEmployee() {
		Mockito.when(employeeService.createEmployee(Mockito.anyObject())).thenReturn("Created");
		Employee employee = new Employee();
		employee.setEmpId(101);
		employee.setFirstName("Archit");
		employee.setLastName("S");
		employee.setEmail("xyz@gmail.com");
		employee.setPhoneNumber("1523885555");
		
		ResponseEntity<String> response=employeeController.createEmployee(employee);
		Assertions.assertEquals("Created", response.getBody());
		logger.info("create employee of controller is working fine");
	}
	@Test
	void testNumeric() {
		Mockito.when(employeeService.createEmployee(Mockito.anyObject())).thenReturn("Created");
		Employee employee = new Employee();
		employee.setEmpId(101);
		employee.setFirstName("Archit");
		employee.setLastName("S");
		employee.setEmail("xyz@gmail.com");
		employee.setPhoneNumber("Arcxldkfnljrnd");
		
		ResponseEntity<String> response=employeeController.createEmployee(employee);
		Assertions.assertEquals("Created", response.getBody());
		logger.info("phone number part of create employee method of controller is accepting values of correct category");
	}
	@Test
	void testGetEmployee() {
		Employee employee = new Employee();
		employee.setEmpId(101);
		employee.setFirstName("Archit");
		employee.setLastName("S");
		employee.setEmail("xyz@gmail.com");
		employee.setPhoneNumber("1523885555");
		Mockito.when(employeeService.getEmployeeById(Mockito.anyInt())).thenReturn(employee);
		employeeController.createEmployee(employee);
		ResponseEntity<Employee> response=employeeController.getEmployeeById(101);
		Assertions.assertEquals(employee, response.getBody());
		logger.info("get employee of controller is working fine");
		
	}
	@Test
	void testGetEmployee_1() {
		ResponseEntity<Employee> response=employeeController.getEmployeeById(101);
		Assertions.assertEquals(null, response.getBody());
		logger.info("get employee of controller is working fine even for null kind of values");
		
	}
}
