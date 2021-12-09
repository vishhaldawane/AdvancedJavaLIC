package com.java.service;

import com.java.entity.Department;
import com.java.repo.DepartmentRepositoryImpl;

public class DepartmentServiceImpl implements DepartmentService {

	DepartmentRepositoryImpl deptRepo = new DepartmentRepositoryImpl();
	
	public DepartmentServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addDepartmentService(Department dept, String username) {
		//.. check who is trying to add
		//ask the password 
		//send the otp
		if(username.equalsIgnoreCase("admin")) {
			System.out.println("Welcome "+username);
			deptRepo.insertDepartment(dept);
			//after insertion send the mail
			System.out.println("dept inserted......");
			System.out.println("sending mail.to the admin..");
		}
		else {
			System.out.println("Only admin can insert the dept....");
			System.out.println("asking password...");
			System.out.println("sending otp...");
		}
		
	}

}
