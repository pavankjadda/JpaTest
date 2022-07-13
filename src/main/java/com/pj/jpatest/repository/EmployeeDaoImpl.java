package com.pj.jpatest.repository;

import com.pj.jpatest.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;

public class EmployeeDaoImpl implements EmployeeDao {
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Employee createNewEmployee() {
    Employee employee = new Employee();
    var employeeId = new Random().nextLong();
    employee.setId(employeeId);
    employee.setFirstName("John");
    employee.setLastName("Doe");
    employee.setEmail("jdoe@example.com");
    employee.setPhoneNumber("123-456-7890");
    entityManager.persist(employee);
    return findByIdFromCustomRepository(employeeId);
  }

  @Override
  public Employee findByIdFromCustomRepository(Long id) {
    return entityManager.find(Employee.class, id);
  }

  @Override
  public List<Employee> findAllCustomRepository() {
    return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
  }
}
