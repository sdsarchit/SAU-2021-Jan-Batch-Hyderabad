package com.asr.main.model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.TestConfiguration;

import com.asr.main.controller.EmployeeController;

class EmployeeTest {
	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@InjectMocks
	Employee employee=new Employee();
	
	public Employee insert() {
		employee.setEmpId(101);
		employee.setFirstName("Archit");
		employee.setLastName("S");
		employee.setEmail("xyz@gmail.com");
		employee.setPhoneNumber("1523885555");
		return employee;
	}
	@Test
	void testGetID() {
		employee=insert();
		Assertions.assertEquals(101,employee.getEmpId());
		logger.info("getId method of employee model is working fine");
	}
	@Test
	void testGetFirstName() {
		employee=insert();
		Assertions.assertEquals("Archit",employee.getFirstName());
		logger.info("getFirstName method of employee model is working fine");
	}
	@Test
	void testGetLastName() {
		employee=insert();
		Assertions.assertEquals("S",employee.getLastName());
		logger.info("getLastName method of employee model is working fine");
	}
	@Test
	void testGetEmail() {
		employee=insert();
		Assertions.assertEquals("xyz@gmail.com",employee.getEmail());
		logger.info("getEmail method of employee model is working fine");
	}
	@Test
	void testGetPhone() {
		employee=insert();
		Assertions.assertEquals("1523885555",employee.getPhoneNumber());
		logger.info("getPhone method of employee model is working fine");
	}
}
