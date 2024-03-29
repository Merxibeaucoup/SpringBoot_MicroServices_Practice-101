package com.edgar.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgar.employeeservice.models.Employee;
import com.edgar.employeeservice.response.APIResponse;
import com.edgar.employeeservice.services.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/new")
	public ResponseEntity<Employee> newEmployee(@RequestBody Employee employee) {
		Employee employee_new = employeeService.newEmployee(employee);
		return new ResponseEntity<>(employee_new, HttpStatus.CREATED);
	}
	
	@GetMapping("/firstname/{firstname}")
	public ResponseEntity<APIResponse> employeeByFirstName(@PathVariable String firstname){
		return ResponseEntity.ok(employeeService.getByFirstName(firstname));
	}
	
	@GetMapping("/lastname/{lastname}")
	public ResponseEntity<Employee> employeeByLastname(@PathVariable String lastname){
		return ResponseEntity.ok(employeeService.getByLastName(lastname));
	}
	
	@GetMapping("/all_employees")
	public ResponseEntity<List<Employee>> allEmployees(){
		return ResponseEntity.ok(employeeService.allEmployeesOnly());
	}
	
	
	@GetMapping("/all")
    public List<APIResponse> getAllEmployeesWithDepartments() {
        return employeeService.getAllEmployeesWithDepartments();
    }
	

}
