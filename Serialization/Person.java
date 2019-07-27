package com.au.Serialization;

public class Person {

	private String FirstName;
	private String LastName;

	public Person(String firstName, String lastName) {
		FirstName = firstName;
		LastName = lastName;
	}

	public Person() {
		FirstName = "fname - default";
		LastName = "lname - default";
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

}
