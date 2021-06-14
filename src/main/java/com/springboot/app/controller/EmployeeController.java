package com.springboot.app.controller;

import com.springboot.app.exceptions.EmployeeNotFoundException;
import com.springboot.app.persistence.Employee;
import com.springboot.app.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public Employee findById(@PathVariable int employeeId) throws EmployeeNotFoundException {
        return employeeService.findById(employeeId);
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());

        return "employees/list-employees";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model theModel) {
        theModel.addAttribute("employee", new Employee());

        return "employees/add-form";
    }

    @PostMapping("/save")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("employeeId") int employeeId, Model model) throws EmployeeNotFoundException {
        model.addAttribute("employee", Optional.ofNullable(employeeService.findById(employeeId)));

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {

        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }

}
