package com.edgar.employeeservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.edgar.employeeservice.requests.DepartmentRequest;

//@FeignClient(url = "http://localhost:8444", value="DEPARTMENT-SERVICE")
@FeignClient(name = "department-service")
public interface APIClient {

	@GetMapping("/api/v1/departments/{code}")
	DepartmentRequest getDepartmentByCode(@PathVariable String code);

}
