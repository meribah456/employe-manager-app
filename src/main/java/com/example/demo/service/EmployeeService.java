package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
@Service
public class EmployeeService {
	private final EmployeeRepo employeeRepo;

	public EmployeeService(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
		
	}
	public Employee getEmployee(Long id) {
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException ("user not found"));
	} 
	public List<Employee> getEmployees(){
		return employeeRepo.findAll();
		
	}   
	public void RemoveEmployee(Long id) {
		 employeeRepo.deleteEmployeeById(null);
		
	}
	 public Employee updateEmployee(Employee employee) {
	        return employeeRepo.save(employee);
	    }

	
}
