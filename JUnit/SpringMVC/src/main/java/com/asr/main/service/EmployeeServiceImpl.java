package com.asr.main.service;

import com.asr.main.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    static List<Employee> employeeList = new ArrayList<>();


    @Override
    public String createEmployee(Employee employee) {
        employeeList.add(employee);
        return "Created successfully!";
    }

    @Override
    public Employee getEmployeeById(int empId) {

        Optional<Employee> employee = employeeList.stream().filter(e -> e.getEmpId() == empId).findFirst();
        return employee.orElse(null);

    }
}
