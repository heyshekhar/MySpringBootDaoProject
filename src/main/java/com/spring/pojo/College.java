package com.spring.pojo;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "college")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int number;
	
	int rollNumber;
	
	String address;
	
	
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
