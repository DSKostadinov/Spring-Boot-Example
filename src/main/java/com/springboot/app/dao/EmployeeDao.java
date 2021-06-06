package com.springboot.app.dao;

import com.springboot.app.persistence.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();
}
