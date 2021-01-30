package com.asr.main.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.asr.main.controller.EmployeeController;
import com.asr.main.model.Employee;

class EmployeeServiceImplTest{
	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);
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
		logger.info("create employee of service is working fine");
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

		logger.info("get employee of controller is working fine");
	}
}
