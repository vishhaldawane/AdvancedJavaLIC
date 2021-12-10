package com.java.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/*
 * deptno	dname loc
 * 10		IT		NY
 * 
 */
@Entity
@Table(name="dept1")
public class Department {
//  DEPTNO DNAME          LOC
	
	@Id
	@Column(name="DEPTNO")
	private int departmentNumber;
	
	@Column(name="DNAME", length=20)
	private String departmentName;
	
	@Column(name="LOC",length=20)
	private String departmentLocation;
	
	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
	Set<Employee> staff = new HashSet<Employee>();
	
	
	public int getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentLocation() {
		return departmentLocation;
	}
	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
	public Set<Employee> getStaff() {
		return staff;
	}
	public void setStaff(Set<Employee> staff) {
		this.staff = staff;
	}
	
	
	
}
