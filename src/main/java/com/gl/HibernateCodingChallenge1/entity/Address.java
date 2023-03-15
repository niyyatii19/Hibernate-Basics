package com.gl.HibernateCodingChallenge1.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String homeAddress;
	private String city;
	private String state;
	private String zipCode;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId")
	private Student student;
	
	public Address(String homeAddress, String city, String state, String zipCode) {
		
		this.homeAddress = homeAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	

	public Address() {
		
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Student getStudent() {
		return student;
	}
	
	



	public void setStudent(Student student) {
		this.student = student;
	}



	public String getHomeAddress() {
		return homeAddress;
	}


	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	

	@Override
	public String toString() {
		return "Address [homeAddress=" + homeAddress + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ "]";
	}
	
	
	
	
	
}
