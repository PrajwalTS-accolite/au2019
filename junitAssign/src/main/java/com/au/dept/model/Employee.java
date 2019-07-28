package com.au.dept.model;

import java.util.Date;

public class Employee {

	private int id;
	private String name;
	private Date DOB;
	private double salary;
	private Date joiningDate;
	
	public Employee() { };


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", DOB=" + DOB + ", salary=" + salary + ", joiningDate="
				+ joiningDate + "]";
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == this)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee e = (Employee) obj;

		if (this.id == e.getId() && this.name.contentEquals(e.getName()) && this.DOB.compareTo(e.getDOB()) == 0
				&& this.joiningDate.compareTo(e.getJoiningDate()) == 0 && this.salary == e.getSalary())
			return true;
		return false;
	}

}
