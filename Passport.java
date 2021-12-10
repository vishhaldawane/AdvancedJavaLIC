package com.java.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
 * passport
 * passport_number	issued_by	issued_on	expiry_on
 * 123123			Ind			10-Jan-2018 10-Jan-2028
 * 423523			Ind			20-Jan-2019 20-Jan-2029
 * 
 * 
 * person_passport
 * passport_number	person_id
 * 123123			101
 * 423523			102
 */
@Entity
@Table(name="passport1")
public class Passport {
	
	@Id
	@Column(name="passport_no")
	@GeneratedValue
	int passportNumber;
	
	@Column(name="issued_by",length=20)
	String issuedBy;
	
	@Column(name="issued_on")
	LocalDate issuedOn;
	
	@Column(name="exipry_on")
	LocalDate expiryOn;
	
	
	@OneToOne(mappedBy = "passport")
	Person person;


	public int getPassportNumber() {
		return passportNumber;
	}


	public void setPassportNumber(int passportNumber) {
		this.passportNumber = passportNumber;
	}


	public String getIssuedBy() {
		return issuedBy;
	}


	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}


	public LocalDate getIssuedOn() {
		return issuedOn;
	}


	public void setIssuedOn(LocalDate issuedOn) {
		this.issuedOn = issuedOn;
	}


	public LocalDate getExpiryOn() {
		return expiryOn;
	}


	public void setExpiryOn(LocalDate expiryOn) {
		this.expiryOn = expiryOn;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
