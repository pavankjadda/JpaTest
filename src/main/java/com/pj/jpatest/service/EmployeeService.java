package com.pj.jpatest.service;


import com.pj.jpatest.domain.Employee;
import com.pj.jpatest.dto.EmployeeDTO;
import com.pj.jpatest.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Service class that implements Business logic for the Employee
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Create a new Employee and persist it to the database.
     *
     * @return the newly created Employee
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    public Employee createNewEmployee() {
        return employeeRepository.createNewEmployee();
    }

    /**
     * Find Employee by ID from the custom repository.
     *
     * @param id the ID of the Employee to find
     *
     * @return the Employee with the given ID
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    public Employee findByIdFromCustomRepository(Long id) {
        return employeeRepository.findByIdFromCustomRepository(id);
    }

    /**
     * Find all Employees in the database.
     *
     * @return list of Employees or an empty list if no Employees are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    public List<Employee> findAllCustomRepository() {
        return employeeRepository.findAllCustomRepository();
    }

    /**
     * Find all Employees in the database.
     *
     * @return list of Employees or an empty list if no Employees are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAllByIdIsNotNull();
    }
}

