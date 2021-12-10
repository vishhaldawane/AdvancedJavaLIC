package com.java;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.java.entity.Department;
import com.java.entity.Employee;
import com.java.repo.BaseRepository;

public class OneToManyTesting {
	
	@Test
	
	public void addNewDepartment()
	{
		BaseRepository baseRepo = new BaseRepository();
		
		Department dept = new Department();
		dept.setDepartmentNumber(10);
		dept.setDepartmentName("IT");
		dept.setDepartmentLocation("NY");
		
		baseRepo.persist(dept);
		
		
	}
	
	@Test
	public void addNewDepartmentWithNewEmployees()
	{
		BaseRepository baseRepo = new BaseRepository();
		
		Department dept = new Department();
		dept.setDepartmentNumber(20);
		dept.setDepartmentName("Test");
		dept.setDepartmentLocation("NJ");

		Employee emp1 = new Employee(100,"Jack",5000,dept);
		Employee emp2 = new Employee(101,"Jack",5000,dept);
		Employee emp3 = new Employee(102,"Jack",5000,dept);
		
		Set<Employee> myEmployees = new HashSet<Employee>();
		myEmployees.add(emp1);
		myEmployees.add(emp2);
		myEmployees.add(emp3);
		
		dept.setStaff(myEmployees);
		
		baseRepo.persist(dept);
		
		
	}
	
	@Test
	public void addNewEmployeesToExistingDeptTest()
	{
		BaseRepository baseRepo = new BaseRepository();
		
		Department dept = baseRepo.find(Department.class, 10);
			
		Employee emp1 = new Employee(500,"Seeta",6000,dept);
		Employee emp2 = new Employee(501,"Rita",7000,dept);
		Employee emp3 = new Employee(502,"Geeta",8000,dept);
		
		Set<Employee> myEmployees = new HashSet<Employee>();
		myEmployees.add(emp1);
		myEmployees.add(emp2);
		myEmployees.add(emp3);
		
		dept.setStaff(myEmployees);
		
		baseRepo.merge(dept);
		
		
	}
	
}
