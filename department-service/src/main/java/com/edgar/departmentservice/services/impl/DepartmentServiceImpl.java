package com.edgar.departmentservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.departmentservice.dto.DepartmentDTO;
import com.edgar.departmentservice.models.Department;
import com.edgar.departmentservice.repository.DepartmentRepository;
import com.edgar.departmentservice.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
		
		
		/**convert department dto to department entity**/
		
		Department department = new Department(
				departmentDTO.getId(),
				departmentDTO.getDepartmentName(),
				departmentDTO.getDepartmentDescription(),
				departmentDTO.getDepartmentCode());

		Department saveDepartment = departmentRepository.save(department);
		
		DepartmentDTO saveDepartmentDto = new DepartmentDTO(
				saveDepartment.getId(),
				saveDepartment.getDepartmentName(),
				saveDepartment.getDepartmentDescription(),
				saveDepartment.getDepartmentCode()
				);
		
		return saveDepartmentDto;
				
	}

	@Override
	public Department getDepartmentByCode(String code) {
		
		if(isExistsByCode(code)) {
			return departmentRepository.findByDepartmentCode(code).get();
		}
		
		else 
			/** using this just for testing**/
			throw new RuntimeException("no doesnt exist");					
		
	}
	
	public boolean isExistsByCode(String code) {
		if(departmentRepository.existsByDepartmentCode(code)) {
			return true;
		}
		else return false;
	}

}
