package com.edgar.departmentservice.services;

import com.edgar.departmentservice.dto.DepartmentDTO;
import com.edgar.departmentservice.models.Department;

public interface DepartmentService {

	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
	
	public Department getDepartmentByCode(String code);

}
