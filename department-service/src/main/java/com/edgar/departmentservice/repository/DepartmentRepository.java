package com.edgar.departmentservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edgar.departmentservice.models.Department;


public interface DepartmentRepository   extends JpaRepository<Department, Long>{
	
	Optional<Department> findByDepartmentName(String departmentName);	
	boolean existsByDepartmentName(String departmentName);
	
	Optional<Department> findByDepartmentCode(String departmentCode);
	boolean existsByDepartmentCode(String departmentCode);

}
