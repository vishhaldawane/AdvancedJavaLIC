package com.java;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DepartmentTest2 {

	DepartmentRepositoryImpl deptRepo = new DepartmentRepositoryImpl();
	
	@Test
	public void insertTest() {
		
			Department dept = new Department();//transient 
			dept.setDepartmentNumber(80);
			dept.setDepartmentName("JPA");
			dept.setDepartmentLocation("pune");
			deptRepo.insertDepartment(dept);
	}
	
	@Test
	public void selectTest() {
			
			Department dept = deptRepo.selectDepartment(10);
			System.out.println("DEPTNO : "+dept.getDepartmentNumber());
			System.out.println("DNAME  : "+dept.getDepartmentName());
			System.out.println("DLOC   : "+dept.getDepartmentLocation());

	}
	
	@Test
	public void selectAllTest() {

		List<Department> deptList = deptRepo.selectDepartments();
			for(Department dept : deptList) {
				System.out.println("DEPTNO : "+dept.getDepartmentNumber());
				System.out.println("DNAME  : "+dept.getDepartmentName());
				System.out.println("DLOC   : "+dept.getDepartmentLocation());
				System.out.println("-------------------");
			}
	}

	
	@Test
	public void updateTest() {
		
		Department dept = new Department();
		dept.setDepartmentNumber(40);
		dept.setDepartmentName("FUN");
		dept.setDepartmentLocation("BORIVALI");

		deptRepo.updateDepartment(dept);
	}
	
	@Test
	public void deleteTest() {

		deptRepo.deleteDepartment(80);
		
	}

	
}
