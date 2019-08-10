package com.au.SpringBoot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.au.SpringBoot.exception.ResourceNotFoundException;
import com.au.SpringBoot.model.Employee;
import com.au.SpringBoot.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeRepository empRepository;
	
	@Value("${assignment.property}")
	private String property;
	
	@GetMapping("/property")
	public String getAppProperty() {
		return property;
	}
	
	//GET
	@GetMapping("/emps")
	public List<Employee> getAllEmployees() {
		return empRepository.findAll();
	}
	
	@PostMapping("/emps")
	public Employee createEmp(@Valid @RequestBody Employee emp) {
	    return empRepository.save(emp);
	}
	
	@GetMapping("/emps/{id}")
	public Employee getEmpById(@PathVariable(value = "id") Long empId) {
	    return empRepository.findById(empId)
	            .orElseThrow( () -> new ResourceNotFoundException("Employee", "id", empId));
	}
	
	// Update a Employee
	@PutMapping("/emps/{id}")
	public Employee updateNote(@PathVariable(value = "id") Long empId,
	                                        @Valid @RequestBody Employee empDetails) {

	    Employee emp = empRepository.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));

	    emp.setName(empDetails.getName());
	    emp.setDOB(empDetails.getDOB());

	    Employee updatedEmp = empRepository.save(emp);
	    return updatedEmp;
	}
	
	// Delete a Employee
	@DeleteMapping("/emps/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long empId) {
	    Employee note = empRepository.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));

	    empRepository.delete(note);

	    return ResponseEntity.ok().build();
	}
	
	

}
