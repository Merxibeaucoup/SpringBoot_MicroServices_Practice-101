package com.edgar.employeeservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.employeeservice.models.Employee;
import com.edgar.employeeservice.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	/** new employee **/
	public Employee newEmployee(Employee employee) {
		if(!isExistByEmail(employee.getEmployeeEmail())) {
			return employeeRepository.save(employee);
		}
		else 
			throw new RuntimeException("An Employee already exists with that email");
	}
	
	
	/** get employee by first name **/
	public Employee getByFirstName(String firstName) {
		if(isExistsByFirstName(firstName)) {
			return employeeRepository.findByEmployeeFirstName(firstName).get();
		}
		else 
			throw new RuntimeException("employee with that name doesnt exist");
		
	}
	
	public Employee getByLastName(String lastname) {
		 Employee employee = employeeRepository.findByEmployeeLastName(lastname)
				 .orElseThrow(()-> new RuntimeException("employee with that lastname doesnt exist"));
		 
		 return employee;
	}
	
	
	
	/** checks **/
	
	
	public boolean isExistByEmail(String email) {
		if(employeeRepository.existsByEmployeeEmail(email)) {
			return true;
		}
		else 
			return false;
	}
	
	public boolean isExistsByFirstName(String firstname) {
		if(employeeRepository.existsByEmployeeFirstName(firstname)) {
			return true;
		}
		else 
			return false;
	}

}
