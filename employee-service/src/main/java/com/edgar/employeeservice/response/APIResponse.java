package com.edgar.employeeservice.response;

import com.edgar.employeeservice.models.Employee;
import com.edgar.employeeservice.requests.DepartmentRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse {
	
	// this class is responsible for comibining both employee and department 

	private Employee employee;

	private DepartmentRequest department;

}
 