package com.pj.jpatest.repository;

import com.pj.jpatest.domain.Employee;

import java.util.List;

public interface CustomEmployeeRepository {
  public Employee createNewEmployee();

  public Employee findByIdFromCustomRepository(Long id);

  public List<Employee> findAllCustomRepository();
}
