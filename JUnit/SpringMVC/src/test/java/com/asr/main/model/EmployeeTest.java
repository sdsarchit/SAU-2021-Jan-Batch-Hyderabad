package com.asr.main.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.TestConfiguration;

class EmployeeTest {
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
	}
	@Test
	void testGetFirstName() {
		employee=insert();
		Assertions.assertEquals("Archit",employee.getFirstName());
	}
	@Test
	void testGetLastName() {
		employee=insert();
		Assertions.assertEquals("S",employee.getLastName());
	}
	@Test
	void testGetEmail() {
		employee=insert();
		Assertions.assertEquals("xyz@gmail.com",employee.getEmail());
	}
	@Test
	void testGetPhone() {
		employee=insert();
		Assertions.assertEquals("1523885555",employee.getPhoneNumber());
	}
}
