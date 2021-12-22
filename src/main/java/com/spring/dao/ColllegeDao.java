package com.spring.dao;

import java.util.List;

import com.spring.pojo.College;

public interface ColllegeDao {

	public int addDetails(College college);
	
	public  List<College> findAllDetailsfromInMemory();
	
	public College findDtailsUsingERollNumInMemory(int rollNum);
	
	public College findDetailsOnDao(int rollNum);
	
	public List<College> findByAddress(String address);
}
