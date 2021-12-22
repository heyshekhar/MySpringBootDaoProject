package com.spring.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.spring.pojo.College;

@Repository("collegeinMemoryDao")
@Profile("dev")
public class CollegeInMemoryDao implements ColllegeDao{

	@Autowired
	public College college;
	
	Map<Integer, College> clgMap = new HashMap<>();
	
	public int addDetails(College college) {
		System.out.println("CollegeInMemoryDao:: going to add college details : " +college.getRollNumber());
		clgMap.put(college.getRollNumber(), college);
		return clgMap.keySet().size();
		
	}
	
	public College findDetailsOnDao(int rollNum) {
		return clgMap.get(rollNum);
	}

	@Override
	public List<College> findByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<College> findAllDetailsfromInMemory() {
		return clgMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public College findDtailsUsingERollNumInMemory(int rollNum) {
		System.out.println("CollegeInMemoryDao: find details using roll number : " +rollNum);
		return clgMap.get(rollNum);
	}
	
}
