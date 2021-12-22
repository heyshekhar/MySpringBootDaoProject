package com.spring.business;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.spring.pojo.College;

public interface CollegeOperation {

	public int addInMemoryDetails(College college);
	
	public College findDetails(int rollNum);

	public List<College> findByAddress(String address);
	
	public String addCollegeDetailsCurd(@RequestBody College college);

	public List<College> findAllDetials();
	
	public College findDtailsUsingERollNumInMemory(int rollNum);
	
	public  List<College> findAllDetailsfromInMemory();

}
