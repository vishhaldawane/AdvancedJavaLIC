package com.java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DepartmentTest {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("Entity Manager Factory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Entity manager : "+entityManager);

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
			Department dept = new Department();//transient 
			dept.setDepartmentNumber(60);
			dept.setDepartmentName("UNIXTRG");
			dept.setDepartmentLocation("pune");
			entityManager.persist(dept); //insert query
		entityTransaction.commit();
		
	}

}
