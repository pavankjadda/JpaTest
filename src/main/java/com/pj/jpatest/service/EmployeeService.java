package com.pj.jpatest.service;


import com.pj.jpatest.domain.Employee;
import com.pj.jpatest.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createNewEmployee() {
        return employeeRepository.createNewEmployee();
    }

    public Employee findByIdFromCustomRepository(Long id) {
        return employeeRepository.findByIdFromCustomRepository(id);
    }

    public List<Employee> findAllCustomRepository() {
        return employeeRepository.findAllCustomRepository();
    }
}

