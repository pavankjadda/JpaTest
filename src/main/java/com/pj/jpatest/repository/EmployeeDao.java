package com.pj.jpatest.repository;

import com.pj.jpatest.domain.Employee;

import java.util.List;

public interface EmployeeDao {
    /**
     * Create a new Employee and persist it to the database.
     *
     * @return the newly created Employee
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    Employee createNewEmployee();

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
    Employee findByIdFromCustomRepository(Long id);

    /**
     * Find all Employees in the database.
     *
     * @return list of Employees or an empty list if no Employees are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    List<Employee> findAllCustomRepository();
}