package com.pj.jpatest.web;

import com.pj.jpatest.domain.Employee;
import com.pj.jpatest.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/find/all")
  public List<Employee> findAll() {
    return employeeService.findAllCustomRepository();
  }

  @GetMapping("/find/{id}")
  public Employee findById(@PathVariable("id") Long id) {
    return employeeService.findByIdFromCustomRepository(id);
  }


  @GetMapping("/create")
  public Employee createNewEmployee() {
    return employeeService.createNewEmployee();
  }
}
