package com.java.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name="passport")
public class Passport {
	
	@Id
	@Column(name="passport_no")
	int passportNumber;
	
	@Column(name="issued_by",length=20)
	String issuedBy;
	
	@Column(name="issued_on")
	LocalDate issuedOn;
	
	@Column(name="exipry_on")
	LocalDate expiryOn;
	
	

}
