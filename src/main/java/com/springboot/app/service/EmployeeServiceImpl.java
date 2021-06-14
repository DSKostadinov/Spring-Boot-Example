package com.springboot.app.service;

import com.springboot.app.persistence.EmployeeRepository;
import com.springboot.app.exceptions.EmployeeNotFoundException;
import com.springboot.app.persistence.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(int id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(String.format("Employee with ID %d not found", id)));
    }
}
