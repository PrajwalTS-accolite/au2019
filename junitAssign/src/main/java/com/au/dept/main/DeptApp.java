package com.au.dept.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.au.dept.model.Department;
import com.au.dept.model.Employee;

public class DeptApp {
	
	Department dept = new Department();
	
	public Employee addEmp(Employee emp) {
		Set<Employee> empsSet = dept.getEmployees();
		if(empsSet == null)
			empsSet = new HashSet<Employee>();
		empsSet.add(emp);
		dept.setEmployees(empsSet);
		return emp;
	}
	
	public boolean delEmp(int id) {
		Set<Employee> empsSet = dept.getEmployees();
		if(empsSet != null) {
			Iterator<Employee> itr = empsSet.iterator();
			while(itr.hasNext()) {
				Employee e = itr.next();
				if(e.getId() == id) {
					itr.remove();
					dept.setEmployees(empsSet);
					return true;
				}
			}
		}
		return false;
	}
	
	public Set<Employee> getAll(){
		return dept.getEmployees();
	}
	
	public Employee findById(int id) {
		Set<Employee> empsSet = dept.getEmployees();
		if(empsSet != null) {
			Iterator<Employee> itr = empsSet.iterator();
			while(itr.hasNext()) {
				Employee e = itr.next();
				if(e.getId() == id) {
					return e;
				}
			}
		}
		return null;
	}
	
	public Employee updateEmp(int id, Employee emp) {
	Set<Employee> empsSet = dept.getEmployees();
	if(empsSet == null)
		empsSet = new HashSet<Employee>();
	Iterator<Employee> itr = empsSet.iterator();
	while(itr.hasNext()) {
		Employee e = itr.next();
		if(e.getId() == id) {
			itr.remove();
		}
	}
	empsSet.add(emp);
	dept.setEmployees(empsSet);
	return emp;
}

}
