package com.au;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Employee {

	private int employeeId;
	private String firstName;
	private String lastName;
	
	public Employee() { };

	public Employee(int employeeId, String firstName, String lastName) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@XmlElement
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	@XmlElement
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@XmlElement
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName;
	}

}