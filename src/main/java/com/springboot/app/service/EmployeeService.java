package com.springboot.app.service;

import com.springboot.app.exceptions.EmployeeNotFoundException;
import com.springboot.app.persistence.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Optional<Employee> findById(int id) throws EmployeeNotFoundException;

    void save(Employee employee);

    void deleteById(int id);
}
