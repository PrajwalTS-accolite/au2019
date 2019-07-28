package com.au.dept.main;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.au.dept.model.Employee;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptAppTest {

	private static DeptApp deptApp;
	private static Employee emp1, emp2, emp3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emp1 = new Employee();
		emp1.setId(1);
		emp1.setDOB(new Date(1997, 6, 12));
		emp1.setJoiningDate(new Date(2019, 5, 23));
		emp1.setName("A");
		emp1.setSalary(100000);
		
		emp2 = new Employee();
		emp2.setId(2);
		emp2.setDOB(new Date(1998, 8, 13));
		emp2.setJoiningDate(new Date(2019, 9, 20));
		emp2.setName("B");
		emp2.setSalary(155000);
		
		emp3 = new Employee();
		emp3.setId(2);
		emp3.setDOB(new Date(1996, 4, 22));
		emp3.setJoiningDate(new Date(2018, 3, 10));
		emp3.setName("C");
		emp3.setSalary(105000);
		
		deptApp = new DeptApp();
//		HashSet<Employee> empSet = new HashSet<Employee>();
//		empSet.add(emp1);
//		deptApp.setEmployees(empSet);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1AddEmp() {
		assertEquals(emp1, deptApp.addEmp(emp1));
		assertEquals(emp2, deptApp.addEmp(emp2));
	}
	
	@Test
	public void test4DelEmp() {
		assertFalse(deptApp.delEmp(6));
		assertTrue(deptApp.delEmp(1));
	}

	@Test
	public void test2GetAll() {
		assertNotNull(deptApp.getAll());
	}
	
	@Test
	public void test3FindById() {
		assertNull(deptApp.findById(6));
		assertNotNull(deptApp.findById(1));
	}
	
	@Test
	public void test5updateEmp() {
		assertSame(emp3, deptApp.updateEmp(2, emp3));
	}
}
