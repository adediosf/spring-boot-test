package com.spring.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by test on 23.04.17.
 */
@Entity
@Table(name="salaries2")
public class Salary implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="salary_id")
    private Long salaryId;

    @ManyToOne()
    @JoinColumn(name = "emp_no", nullable = false)
    private Employee employee;

    @Column(name="salary")
    private Long salary;

    @Column(name="fromDate")
    @NotNull
    private Date fromDate;

    @Column(name="toDate")
    @NotNull
    private Date toDate;

    public Long getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee emp_no) {
        this.employee = emp_no;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Salary(Employee empl_no, Long salary, Date fromDate, Date toDate) {
        this.employee = empl_no;
        this.salary = salary;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Salary(){}
}
