package com.java.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/*
 * empno ename salary  dno
 * 101   jack	5400	10
 * 102	 jane	3444	10
 * 103	 jill	9349	10
 */
@Entity
@Table(name="employee1")
public class Employee {
// EMPNO ENAME      JOB              MGR HIREDATE         SAL       COMM

//    DEPTNO

	@Id
	@Column(name="empno")
	private int employeeNumber;
	
	@Column(name="empname", length=20)
	private String employeeName;
	
	@Column(name="salary")
	private float salary;
	
	@ManyToOne
	@JoinColumn(name="dno")
	Department dept;

	public Employee() {
		System.out.println("Employee() ctor...");
	}
	public Employee(int employeeNumber, String employeeName, float salary, Department dept) {
		super();
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.salary = salary;
		this.dept = dept;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
    
	
	
}
