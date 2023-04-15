package com.edgar.departmentservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgar.departmentservice.dto.DepartmentDTO;
import com.edgar.departmentservice.services.impl.DepartmentServiceImpl;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;

	/** save department restAPI**/
	
	@PostMapping("/new")
	public ResponseEntity<DepartmentDTO> newDepartment(@RequestBody DepartmentDTO departmentDTO){
		DepartmentDTO savedDepartment = departmentServiceImpl.saveDepartment(departmentDTO);	
		return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
	}

}
