package com.springboot.app.controller;

import com.springboot.app.exceptions.EmployeeNotFoundException;
import com.springboot.app.persistence.Employee;
import com.springboot.app.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeRestController {

    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeRestController.class);

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) throws EmployeeNotFoundException {
        return employeeService.findById(employeeId);
    }

}
