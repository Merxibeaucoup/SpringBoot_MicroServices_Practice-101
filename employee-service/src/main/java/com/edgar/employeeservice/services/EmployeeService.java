package com.edgar.employeeservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.edgar.employeeservice.models.Employee;
import com.edgar.employeeservice.repositories.EmployeeRepository;
import com.edgar.employeeservice.requests.DepartmentRequest;
import com.edgar.employeeservice.response.APIResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	private RestTemplate restTemplate;
	
	private WebClient webClient;
	
	
	/** new employee **/
	public Employee newEmployee(Employee employee) {
		if(!isExistByEmail(employee.getEmployeeEmail())) {
			return employeeRepository.save(employee);
		}
		else 
			throw new RuntimeException("An Employee already exists with that email");
	}
	
	
	/** get employee by first name and also get employee department code **/
	public APIResponse getByFirstName(String firstName) {
		
		Employee employee = employeeRepository.findByEmployeeFirstName(firstName).get();
		
		
//	ResponseEntity<DepartmentRequest> responseEntity =	restTemplate.getForEntity("http://localhost:8443/api/v1/departments/"+ employee.getDepartmentCode(), DepartmentRequest.class);
//	
//	DepartmentRequest departmentRequest = responseEntity.getBody();
		
		DepartmentRequest departmentRequest = webClient
						.get()
						.uri("http://localhost:8444/api/v1/departments/"+ employee.getDepartmentCode())
						.retrieve()
						.bodyToMono(DepartmentRequest.class)
						.block();
		
		
		if(isExistsByFirstName(firstName)) {		
			APIResponse apiResponse = new APIResponse();
			apiResponse.setDepartment(departmentRequest);
			apiResponse.setEmployee(employee);
			
			
			return apiResponse;
		}
		else 
			throw new RuntimeException("employee with that name doesnt exist");
		
	}
	
	
	
	
	
	
	/** get employee by last name **/
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
