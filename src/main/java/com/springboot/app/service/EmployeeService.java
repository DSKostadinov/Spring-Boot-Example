package com.springboot.app.service;

import com.springboot.app.exceptions.EmployeeNotFoundException;
import com.springboot.app.persistence.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findById(int id) throws EmployeeNotFoundException;
}
