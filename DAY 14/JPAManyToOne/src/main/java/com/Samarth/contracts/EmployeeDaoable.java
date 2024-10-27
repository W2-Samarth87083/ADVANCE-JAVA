package com.Samarth.contracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Samarth.entities.Employee;

public interface EmployeeDaoable extends JpaRepository<Employee, Integer> {
	List<Employee> findByJob(String job);
	List<Employee> findByEnameStartsWith(String prefix);
}
