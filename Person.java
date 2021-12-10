package com.java.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
 * person
 * person_id	person_name		birth_date	passid
 * 101			jack			10-Jan-1990	123123
 * 102			jane			12-Feb-2002 423523
 */
@Entity
@Table(name="person1")
public class Person {

	@Id
	@Column(name="person_id")
	@GeneratedValue // no need to specifiy the person id 
	int personId;
	
	//@SequenceGenerator
	
	@Column(name="person_name", length=20)
	String personName;
	
	@Column(name="birth_date")
	LocalDate birthDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="passid")
	Passport passport;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	
	
}
