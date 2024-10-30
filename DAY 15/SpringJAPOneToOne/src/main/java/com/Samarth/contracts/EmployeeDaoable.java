package com.Samarth.contracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Samarth.entities.Employee;

public interface EmployeeDaoable extends JpaRepository<Employee, Integer> {

}
