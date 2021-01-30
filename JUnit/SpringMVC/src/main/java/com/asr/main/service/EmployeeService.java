package com.asr.main.service;

import com.asr.main.model.Employee;

public interface EmployeeService {

    public String createEmployee(Employee employee);
    public Employee  getEmployeeById(int empId);
}
