package com.java.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
 * person
 * person_id	person_name		birth_date	passid
 * 101			jack			10-Jan-1990	123123
 * 102			jane			12-Feb-2002 423523
 */
@Entity
@Table(name="person")
public class Person {

	@Id
	@Column(name="person_id")
	int personId;
	
	@Column(name="person_name", length=20)
	String personName;
	
	@Column(name="birth_date")
	LocalDate birthDate;
	
	@OneToOne
	Passport passport;
}
