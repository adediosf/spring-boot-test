package com.spring.dao;

import com.spring.entities.Employee;
import com.spring.entities.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;

/**
 * Created by test on 23.04.17.
 */
public interface SalaryRepository extends JpaRepository<Salary, Long> {
    Collection<Salary> findByEmployeeFirstName(String firstName);

    Collection<Salary> findByEmployeeId(Long id);

    Salary findBySalaryId(Long id);
}
