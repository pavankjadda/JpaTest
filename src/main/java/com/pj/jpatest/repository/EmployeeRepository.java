package com.pj.jpatest.repository;

import com.pj.jpatest.domain.Employee;
import com.pj.jpatest.dto.EmployeeDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeDao {
    List<EmployeeDTO> findAllByIdIsNotNull();
}