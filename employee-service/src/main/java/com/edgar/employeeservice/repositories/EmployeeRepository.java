package com.edgar.employeeservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edgar.employeeservice.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	
	Optional<Employee> findByEmployeeFirstName(String employeeFirstName);
	boolean existsByEmployeeFirstName(String employeeFirstName);
	
	
	Optional<Employee> findByEmployeeLastName(String employeeLastName);
	boolean existsByEmployeeLastName(String employeeLastName);
	
	
	
	boolean existsByEmployeeEmail(String employeeEmail);

}
