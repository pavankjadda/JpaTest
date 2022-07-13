package com.pj.jpatest.web;

import com.pj.jpatest.domain.Employee;
import com.pj.jpatest.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Provides a REST API endpoints for the Employee entity.
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  /**
   * Find all Employees in the database.
   *
   * @return list of Employees or an empty list if no Employees are found
   *
   * @author Pavan Kumar Jadda
   * @since 1.0.0
   */
  @GetMapping("/find/all")
  public List<Employee> findAll() {
    return employeeService.findAllCustomRepository();
  }

  @GetMapping("/find/{id}")
  public Employee findById(@PathVariable("id") Long id) {
    return employeeService.findByIdFromCustomRepository(id);
  }


  /**
   * Create a new Employee and persist it to the database.
   *
   * @return the newly created Employee
   *
   * @author Pavan Kumar Jadda
   * @since 1.0.0
   */
  @GetMapping("/create")
  public Employee createNewEmployee() {
    return employeeService.createNewEmployee();
  }
}
