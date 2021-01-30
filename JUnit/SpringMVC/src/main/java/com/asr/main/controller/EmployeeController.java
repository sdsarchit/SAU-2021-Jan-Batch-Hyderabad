package com.asr.main.controller;
import java.util.*;
import java.lang.*;
import com.asr.main.model.Employee;
import com.asr.main.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        //System.out.println("API hit!");
        if(org.apache.commons.lang3.StringUtils.isNumeric(employee.getPhoneNumber())) {}
        String response = employeeService.createEmployee(employee);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int empId){
        //System.out.println("API hit!");
        Employee employee =  employeeService.getEmployeeById(empId);
        if(Objects.nonNull(employee))
           return ResponseEntity.ok(employee);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
