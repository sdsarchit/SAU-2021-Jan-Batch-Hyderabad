package com.asr.main.service;


import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.asr.main.controller.EmployeeController;
import com.asr.main.model.Employee;

class EmployeeServiceImplTest{
	@Mock
	EmployeeController emp;

    @Autowired
    private EmployeeService employeeService=new EmployeeServiceImpl();
    @MockBean
    private Employee employee;
     
	@Test
	void testCreate() {
		Employee employee = new Employee();
		Assertions.assertEquals("Created successfully!", employeeService.createEmployee(employee));
	}
	@Test
	void testGet_1() {
		Employee employee = new Employee();
		employee.setEmpId(101);
		employee.setFirstName("Archit");
		employee.setLastName("S");
		employee.setEmail("xyz@gmail.com");
		employee.setPhoneNumber("1523885555");
		Assertions.assertEquals("Created successfully!", employeeService.createEmployee(employee));
		Assertions.assertEquals(employee,employeeService.getEmployeeById(101));
		Assertions.assertEquals(null,employeeService.getEmployeeById(1000));
	}
}
