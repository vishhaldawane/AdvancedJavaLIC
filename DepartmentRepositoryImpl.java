package com.java;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

//import com.java.entity.Department;

public class DepartmentRepositoryImpl implements DepartmentRepository {

	List<Department> deptList = new ArrayList<Department>();
	
	EntityManager entityManager;
	
	public DepartmentRepositoryImpl() {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("Entity Manager Factory : "+entityManagerFactory);
		
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Entity manager : "+entityManager);
			
	}

	@Override
	public void insertDepartment(Department dept) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
			entityManager.persist(dept);
		transaction.commit();
	}

	@Override
	public void updateDepartment(Department dept) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
			entityManager.merge(dept);
		transaction.commit();
		

	}

	@Override
	public void deleteDepartment(int deptno) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
			Department dept = entityManager.find(Department.class,deptno);
			entityManager.remove(dept);
		transaction.commit();

	}

	@Override
	public Department selectDepartment(int deptno) {
		Department dept = entityManager.find(Department.class,deptno);
		return dept;
	}

	@Override
	public List<Department> selectDepartments() {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("Entity Manager Factory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Entity manager : "+entityManager);
			
			Query query = entityManager.createQuery("from Department");//<-JPQL     and NOT -> SQL "from dept" <-- is invalid
			List<Department> deptList = query.getResultList();
			
		return deptList;
	}

}
