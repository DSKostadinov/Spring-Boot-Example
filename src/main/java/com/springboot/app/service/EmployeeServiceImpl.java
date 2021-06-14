package com.springboot.app.service;

import com.springboot.app.persistence.EmployeeRepository;
import com.springboot.app.exceptions.EmployeeNotFoundException;
import com.springboot.app.persistence.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) throws EmployeeNotFoundException {
        return Optional.ofNullable(
                employeeRepository.findById(id)
                ).orElseThrow(() -> new EmployeeNotFoundException(String.format("Employee with ID %d not found", id)));
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
