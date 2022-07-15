package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	 @Autowired 
	 EmployeeService employeeService;

	
	
   @GetMapping(value="/all") 
   public ResponseEntity<List<Employee>> getAllEmployees(){
	   List<Employee> employees =employeeService.getEmployees();
	   return new ResponseEntity<>( employees,HttpStatus.OK);
   }
   
   @GetMapping(value="/find/{id}") 
   public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){
	   Employee employee =employeeService.getEmployee(id);
	   return new ResponseEntity<>( employee,HttpStatus.OK);
   }
   @GetMapping(value="/delete/{id}") 
   public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id){
	   employeeService.RemoveEmployee(id);
	   return new ResponseEntity<>( HttpStatus.OK);
   }
   @PostMapping (value="/add")
   public ResponseEntity<Employee> AddEmployee(@RequestBody Employee employee){
	   Employee emp = employeeService.addEmployee(employee);
	   return new ResponseEntity<>( emp,HttpStatus.OK);
   }
   @PutMapping(value="/update")
   public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
	   Employee empupdate = employeeService.updateEmployee(employee);
	   return new ResponseEntity<>( empupdate,HttpStatus.OK);
   }

}
