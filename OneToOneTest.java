package com.java;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.java.entity.Passport;
import com.java.entity.Person;
import com.java.repo.BaseRepository;

public class OneToOneTest {

	
	@Test
	public void insertNewPersonTest() {
		
		BaseRepository baseRepo = new BaseRepository();
		
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();
		
		person1.setPersonName("Vishhal");
		person1.setBirthDate(LocalDate.of(1999, 01, 14));
		
		person2.setPersonName("Anoop");
		person2.setBirthDate(LocalDate.of(1998, 02, 24));
		
		person3.setPersonName("Kuntal");
		person3.setBirthDate(LocalDate.of(1998, 03, 24));
		
		//baseRepo.persist(person1);
		baseRepo.persist(person2);
		baseRepo.persist(person3);
	}
	
	@Test
	public void insertNewPassportTest() {
		
		
		BaseRepository baseRepo = new BaseRepository();
		
		Passport passport1 = new Passport();
		Passport passport2 = new Passport();
		Passport passport3 = new Passport();
		
		
		passport1.setIssuedBy("Govt.Of India");
		passport1.setIssuedOn(LocalDate.of(2020, 01, 14));
		passport1.setExpiryOn(LocalDate.of(2030, 01, 14));
	
		passport2.setIssuedBy("Govt.Of India");
		passport2.setIssuedOn(LocalDate.of(2018, 11, 24));
		passport2.setExpiryOn(LocalDate.of(2028, 11, 24));
	
		passport3.setIssuedBy("Govt.Of India");
		passport3.setIssuedOn(LocalDate.of(2019, 03, 4));
		passport3.setExpiryOn(LocalDate.of(2029, 03, 4));
		
		baseRepo.persist(passport1);
		baseRepo.persist(passport2);
		baseRepo.persist(passport3);
	}
	
	@Test
	public void assignExistingPassportToExistingPersonTest() {
		
		BaseRepository baseRepo = new BaseRepository();
		
		Person person = baseRepo.find(Person.class, 1);
		
		
		Passport passport = baseRepo.find(Passport.class, 4);
		
	//	person.setPersonName("Jack");
			
		person.setPassport(passport); //setting the fk
		
		baseRepo.merge(person);
		
		
		
	}
	@Test
	public void assignExistingPersonToExistingPassportTest() {
		
		BaseRepository baseRepo = new BaseRepository();
		
		Person person = baseRepo.find(Person.class, 2);
		
		
		Passport passport = baseRepo.find(Passport.class, 5);
		
	//	person.setPersonName("Jack");
			
	//	person.setPassport(passport); //setting the fk
		passport.setPerson(person);
		
		baseRepo.merge(passport);
		
		
		
	}
	
	@Test
	public void assignBothExistingPersonToExistingPassportTest() {
		
		BaseRepository baseRepo = new BaseRepository();
		
		Person person = baseRepo.find(Person.class, 3);
		
		
		Passport passport = baseRepo.find(Passport.class, 6);
		
		person.setPersonName("KUNTAL");
		person.setPassport(passport); //setting the fk
		
		passport.setIssuedBy(passport.getIssuedBy().toUpperCase());
		passport.setPerson(person);
		
		baseRepo.merge(person);
		baseRepo.merge(passport);
		
		
		
	}
	
	
	@Test
	public void addNewPersonWithNewPassportTest()
	{
		
		BaseRepository baseRepo = new BaseRepository();
		
		Person person1 = new Person();
		person1.setPersonName("Jack");
		person1.setBirthDate(LocalDate.of(1999, 01, 14));
		
		
		Passport passport1 = new Passport();
		passport1.setIssuedBy("Govt.Of Nepal");
		passport1.setIssuedOn(LocalDate.of(2020, 01, 14));
		passport1.setExpiryOn(LocalDate.of(2030, 01, 14));
	
		person1.setPassport(passport1);
		//passport1.setPerson(person1);
		
		baseRepo.persist(person1);
		//baseRepo.persist(passport1);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
