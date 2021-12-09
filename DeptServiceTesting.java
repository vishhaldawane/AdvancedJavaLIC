package com.java;

import org.junit.jupiter.api.Test;

import com.java.entity.Department;
import com.java.service.DepartmentServiceImpl;

public class DeptServiceTesting {

	DepartmentServiceImpl deptService = new DepartmentServiceImpl();
	
	@Test
	public void insertDeptSeviceTest() {
		Department dept = new Department();
		dept.setDepartmentNumber(55);
		dept.setDepartmentName("FUNNN");
		dept.setDepartmentLocation("MDC");
		
		deptService.addDepartmentService(dept,"Admin");
	}
}





