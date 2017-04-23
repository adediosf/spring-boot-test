package com.spring.controllers;

import com.spring.dao.EmployeeRepository;
import com.spring.dao.SalaryRepository;
import com.spring.entities.Employee;
import com.spring.entities.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

/**
 * Created by test on 23.04.17.
 */
@RestController
@RequestMapping("/{employee_id}/salaries")
public class SalaryController {

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(method= RequestMethod.GET)
    Collection<Salary> getSalaries(@PathVariable Long employee_id) {
        this.validateId(employee_id);
        return this.salaryRepository.findByEmployeeId(employee_id);
    }


    @RequestMapping(method=RequestMethod.POST)
    ResponseEntity <?> addSalary(@PathVariable Long employee_id, @RequestBody Salary body) {
        this.validateId(employee_id);

        return this.employeeRepository
                .findById(employee_id)
                .map( emp -> {
                    System.out.println("saving");
                        Salary sal = salaryRepository.save(new Salary(emp, body.getSalary(), body.getFromDate(), body.getToDate()));

                        URI location = ServletUriComponentsBuilder
                                .fromCurrentRequest().path("/{salaryId}")
                                .buildAndExpand(sal.getSalaryId()).toUri();

                        return ResponseEntity.created(location).build();
                })
                .orElse(ResponseEntity.noContent().build());

    }


    @RequestMapping(method=RequestMethod.GET, value = "/{salaryId}" )
    Salary getSalary(@PathVariable  Long employee_id, @PathVariable Long salaryId){
        this.validateId(employee_id);
        return this.salaryRepository.findBySalaryId(salaryId);
    }


    private void validateId(Long employee_id) {
        this.employeeRepository.findById(employee_id).orElseThrow( () -> new EmployeeNotFoundException(employee_id));
    }

}
