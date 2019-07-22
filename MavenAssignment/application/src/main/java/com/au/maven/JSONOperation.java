package com.au.maven;

import com.au.maven.application.Employee;
import com.au.utility.ObjectToJSON;

public class JSONOperation {
	
	public static void main(String[] args) {
		Employee emp = new Employee(23, "A");
		System.out.println(ObjectToJSON.convertToJSON(emp));
	}

}