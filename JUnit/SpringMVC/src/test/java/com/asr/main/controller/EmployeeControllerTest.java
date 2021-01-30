package com.asr.main.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import com.asr.main.model.Employee;
import com.asr.main.service.EmployeeService;
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {
	
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
		
	}
	@Test
	void testGetEmployee_1() {
		ResponseEntity<Employee> response=employeeController.getEmployeeById(101);
		Assertions.assertEquals(null, response.getBody());
		
	}
}
