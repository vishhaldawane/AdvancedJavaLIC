package com.java.repo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.java.entity.Department;

public class BaseRepository {
	
		EntityManager entityManager;
		EntityManagerFactory entityManagerFactory ;
		
		public BaseRepository() {
			 entityManagerFactory =
					Persistence.createEntityManagerFactory("MyJPA");
			System.out.println("Entity Manager Factory : "+entityManagerFactory);
			entityManager = entityManagerFactory.createEntityManager();
			
		}

		public EntityManager getEntityManager() {
			
			return entityManager;
		}
		
		public void persist(Object obj) { //persist is a dummy/userdefined name
			
			try {
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				System.out.println("Entity manager : "+entityManager);
					EntityTransaction trans = entityManager.getTransaction();
					trans.begin();
					entityManager.persist(obj);
					trans.commit();
			} finally { entityManager.close(); }

		}
		
				//find(Dept.class,10),   find(Emp.class,22);
		public<T> 
		
		T find(Class<T> theClass, Serializable pk ) {
			T foundObj = null;
			try {			
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				System.out.println("Entity manager : "+entityManager);
				foundObj = entityManager.find(theClass, pk);	
			} finally { entityManager.close(); }
				return foundObj;
		}
		
	
		public <E> List  findAll(String pojoName) {
			try {			
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				System.out.println("Entity manager : "+entityManager);
				Query query = entityManager.createQuery(" from "+ pojoName); //its not sql, hence it is NOT select * from dept, rather it is select * from Department 
				return query.getResultList();
			} finally { entityManager.close(); }
		}
		
		
		public void merge(Object obj) { //update query, if the record doesnot exist, it will insert else update 
			
			try {
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				System.out.println("Entity manager : "+entityManager);
				EntityTransaction trans = entityManager.getTransaction();
				trans.begin();
				entityManager.merge(obj); //<--real call for jdbc here	
				trans.commit();
			} finally { entityManager.close(); }
			
		}
		
	
		public <AnyClass> void remove(Class<AnyClass> theClass, Serializable pk) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Entity manager : "+entityManager);
			EntityTransaction trans = entityManager.getTransaction();
			trans.begin();
				AnyClass anyClass = entityManager.find(theClass, pk);
				if(anyClass==null) {
					throw new RuntimeException("Object not found to delete");
				}
				entityManager.remove(anyClass);
			trans.commit();
			} finally { entityManager.close(); }
		}
	

}
