package com.pj.jpatest.repository;

import com.pj.jpatest.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeDao {

}
