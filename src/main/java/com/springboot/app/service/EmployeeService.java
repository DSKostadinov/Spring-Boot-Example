package com.springboot.app.service;

import com.springboot.app.exceptions.EmployeeNotFoundException;
import com.springboot.app.persistence.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id) throws EmployeeNotFoundException;

    void save(Employee employee);

    void deleteById(int id);
}