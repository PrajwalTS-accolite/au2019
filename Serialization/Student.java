package com.au.Serialization;

import java.io.Serializable;

public class Student extends Person implements Serializable {

	private int studentId;
	private String standard;
	private String division;
	transient private int mark;
	Address addr;

	public Student(String firstName, String lastName, int studentId, String standard, String division, int mark,
			Address addr) {
		super(firstName, lastName);
		this.studentId = studentId;
		this.standard = standard;
		this.division = division;
		this.mark = mark;
		this.addr = addr;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + super.getFirstName() + ", lastName="
				+ super.getLastName() + ", standard=" + standard + ", division=" + division + ", mark=" + mark
				+ ", addr=" + addr + "]";
	}

}
