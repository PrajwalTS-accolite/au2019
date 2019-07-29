package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Serviceimpl {
	private static HashMap<Integer, Employee> empMap = new HashMap<>();

	@GET
	@Path("/employeeList")
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> empList = new ArrayList<>(empMap.values());
		return empList;
	}

	@POST
	@Path("/add")
	public String addEmployee(Employee e) {
		if (empMap.get(e.getId()) != null) {
			return "Error! Trying to add existing employee.";
		}

		empMap.put(e.getId(), e);
		return "Success! Employee added.";
	}

	@GET
	@Path("/{id}/delete")
	public String deleteEmployee(@PathParam("id") int id) {

		if (empMap.containsKey(id)) {
			empMap.remove(id);
			return "Success! Employee deleted.";
		}

		return "Error! Employee does not exist.";
	}

	@GET
	@Path("/{id}/search")
	public String searchEmployee(@PathParam("id") int id) {

		if (empMap.containsKey(id)) {
			return empMap.get(id).toString();
		}

		return "Error! Employee does not exist.";
	}

	@GET
	@Path("/{id}/modify/name/{name}")
	public String modifyEmployeeByName(@PathParam("id") int id, @PathParam("name") String name) {
		if (empMap.get(id) != null) {
			Employee e = empMap.get(id);
			e.setName(name);
			empMap.replace(id, e);
			return "Success! Employee name updated.";
		}
		return "Error! Employee does not exist.";

	}

	@GET
	@Path("/{id}/modify/age/{age}")
	public String modifyEmployeeByAge(@PathParam("id") int id, @PathParam("age") int age) {
		if (empMap.get(id) != null) {
			Employee e = empMap.get(id);
			e.setAge(age);
			empMap.replace(id, e);
			return "Success! Employee age updated.";
		}
		return "Error! Employee does not exist.";

	}
}