package com.pj.jpatest.repository;

import com.pj.jpatest.domain.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides a DAO class that uses EntityManager to get employee data rather than Spring Data JPA.
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Create a new Employee and persist it to the database.
     *
     * @return the newly created Employee
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public Employee createNewEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmail("jdoe@example.com");
        employee.setPhoneNumber("123-456-7890");
        entityManager.persist(employee);
        return findByIdFromCustomRepository(employee.getId());
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
    @Override
    public Employee findByIdFromCustomRepository(Long id) {
        return entityManager.find(Employee.class, id);
    }

    /**
     * Find all Employees in the database.
     *
     * @return list of Employees or an empty list if no Employees are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public List<Employee> findAllCustomRepository() {
        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }
}
