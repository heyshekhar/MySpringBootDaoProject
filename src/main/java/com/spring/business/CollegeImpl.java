package com.spring.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.dao.CollegeRepository;
import com.spring.dao.ColllegeDao;
import com.spring.pojo.College;

@Service
public class CollegeImpl implements CollegeOperation {

	@Autowired
	//@Qualifier("collegeDaoImpl")
	@Qualifier("collegeinMemoryDao")
	private ColllegeDao collegeDao;
	
	@Autowired
	CollegeRepository collegeRepository;

	public int addInMemoryDetails(College college) {
		int result = collegeDao.addDetails(college);
		return result;
	}

	public College findDetails(int id) {
		System.out.println("find details of rollnum" + id);
		return collegeDao.findDetailsOnDao(id);

	}

	@Override
	public List<College> findByAddress(String address) {
		// TODO Auto-generated method stub
//		return collegeDao.findByAddress(address);
		
//		return collegeRepository.findByAddress(address);
		
		return collegeRepository.myComplexMethodQuery(address);
	}
	
	@Override
	public String addCollegeDetailsCurd(@RequestBody College college) {
		System.out.println("request :"+college.getRollNumber()+    college.getAddress());
		collegeRepository.save(college);
		return college.toString();
	}
	
	@Override
	public List<College> findAllDetials() {
		return collegeRepository.findAll();
	}

	@Override
	public College findDtailsUsingERollNumInMemory(int rollNum) {
		return collegeDao.findDtailsUsingERollNumInMemory(rollNum);
	}

	@Override
	public List<College> findAllDetailsfromInMemory() {
		
		return collegeDao.findAllDetailsfromInMemory();
	}

}
