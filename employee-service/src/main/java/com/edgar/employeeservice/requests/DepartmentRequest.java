package com.edgar.employeeservice.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequest {
	
	private Long id;
	
	private String departmentName;	

	private String departmentDescription;

	private String departmentCode;

}
