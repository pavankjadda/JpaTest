package com.pj.jpatest.repository;

import com.pj.jpatest.domain.Employee;

import java.util.List;

public interface EmployeeDao {
  Employee createNewEmployee();

  Employee findByIdFromCustomRepository(Long id);

  List<Employee> findAllCustomRepository();
}
