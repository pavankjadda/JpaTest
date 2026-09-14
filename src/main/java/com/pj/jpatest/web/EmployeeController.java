package com.pj.jpatest.web;

import com.pj.jpatest.domain.Employee;
import com.pj.jpatest.dto.EmployeeDTO;
import com.pj.jpatest.service.EmployeeService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides a REST API endpoint for the Employee entity.
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
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
    public List<EmployeeDTO> findAll() {
        return service.findAll();
    }

    /**
     * Find all Employees in the database with custom repository
     *
     * @return list of Employees or an empty list if no Employees are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/find/all/custom")
    public List<Employee> findAllCustomRepository() {
        return service.findAllCustomRepository();
    }

    /**
     * Find Employee by ID
     *
     * @return Employee that matches the given ID
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/find/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        return service.findByIdFromCustomRepository(id);
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
        return service.createNewEmployee();
    }
}