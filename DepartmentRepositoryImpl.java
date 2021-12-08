package com.java.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.entity.Department;

public class DepartmentRepositoryImpl implements DepartmentRepository {

	List<Department> deptList = new ArrayList<Department>();
	
	Connection conn; //global connection available to all the methods
	
	public DepartmentRepositoryImpl() {
		try {
			//1
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver registered....");
			
			//2
			this.conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"system","tiger");
			System.out.println("Connected to the DB : "+conn); 
			
			//3
			Statement statement = conn.createStatement();
			System.out.println("statement created..."+statement);
			
			ResultSet result = statement.executeQuery("select * from dept where deptno=20");
			System.out.println("Got the result set : "+result);
		
			while(result.next()) {
				Department deptObj = new Department();
				deptObj.setDepartmentNumber(result.getInt(1));
				deptObj.setDepartmentName(result.getString(2));
				deptObj.setDepartmentLocation(result.getString(3));
				deptList.add(deptObj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insertDepartment(Department dept) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDepartment(Department dept) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDepartment(int deptno) {
		// TODO Auto-generated method stub

	}

	@Override
	public Department selectDepartment(int deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> selectDepartments() {
		return deptList;
	}

}
