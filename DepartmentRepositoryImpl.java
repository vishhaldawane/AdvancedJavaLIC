package com.java.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insertDepartment(Department dept) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = conn.prepareStatement("insert into dept values (?,?,?)");
			pst.setInt(1, dept.getDepartmentNumber());
			pst.setString(2, dept.getDepartmentName());
			pst.setString(3, dept.getDepartmentLocation());
			int rows = pst.executeUpdate(); // fire the query
			System.out.println("Record inserted...."+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = conn.prepareStatement("update dept set dname=?, loc=? where deptno=?");
			
			pst.setString(1, dept.getDepartmentName());
			pst.setString(2, dept.getDepartmentLocation());
			pst.setInt(3, dept.getDepartmentNumber());
			
			int rows = pst.executeUpdate(); // fire the query
			System.out.println("Record update...."+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void deleteDepartment(int deptno) {
		try {
			PreparedStatement pst = conn.prepareStatement("delete from dept where deptno=?");
			
			pst.setInt(1, deptno);
			
			
			int rows = pst.executeUpdate(); // fire the query
			System.out.println("Record deleted...."+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Department selectDepartment(int deptno) {
		Department deptObj = null;
		try {
	//3
			Statement statement = conn.createStatement();
			System.out.println("statement created..."+statement);
			
			ResultSet result = statement.executeQuery("select * from dept where deptno="+deptno);
			System.out.println("Got the result set : "+result);
	
			if(result.next()) {
				deptObj = new Department();
				deptObj.setDepartmentNumber(result.getInt(1));
				deptObj.setDepartmentName(result.getString(2));
				deptObj.setDepartmentLocation(result.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptObj;
	}

	@Override
	public List<Department> selectDepartments() {
		
		//3
		try {
			Statement statement = conn.createStatement();
			System.out.println("statement created..."+statement);
			
			ResultSet result = statement.executeQuery("select * from dept");
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
		return deptList;
	}

}
