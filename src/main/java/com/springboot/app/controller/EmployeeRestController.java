package com.springboot.app.controller;

import com.springboot.app.dao.EmployeeDao;
import com.springboot.app.exceptions.EmployeeNotFoundException;
import com.springboot.app.persistence.Employee;
import com.springboot.app.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeRestController.class);

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) throws EmployeeNotFoundException {
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        LOGGER.info("Updating employee {}...", employee.toString());

        employeeService.save(employee);

        LOGGER.info("Employee updated to {}.", employee.toString());

        return employee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) throws EmployeeNotFoundException {
        Employee employee = employeeService.findById(employeeId);

        LOGGER.info("Deleting employee {}...", employee.toString());

        employeeService.deleteById(employeeId);

        LOGGER.info("Employee successfully deleted.");
    }
}
