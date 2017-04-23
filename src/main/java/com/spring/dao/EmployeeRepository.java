package com.spring.dao;

import com.spring.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by test on 23.04.17.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Optional<Employee> findByFirstName(String first_name);

    Optional<Employee> findById(Long id);

}
