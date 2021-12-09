package com.java;

import java.util.List;

//import com.java.entity.Department;

public interface DepartmentRepository {
	void insertDepartment(Department dept);
	void updateDepartment(Department dept);
	void deleteDepartment(int deptno); // by deptno
	Department selectDepartment(int deptno); //single
	List<Department> selectDepartments(); // all
}
