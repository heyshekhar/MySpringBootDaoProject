package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.pojo.College;

@Repository ("collegeDaoImpl")
@Transactional
//@Profile("test")
public class CollegeDaoImpl implements ColllegeDao {

	@Autowired
	EntityManager entityManager;

	public int addDetails(College college) {
		System.out.println("CollegeDaoImpl:: going to add college details : " + college.getRollNumber());
		entityManager.persist(college);
		return college.getRollNumber();
	}

	@Override
	public College findDetailsOnDao(int rollNum) {
		System.out.println("find details of rollnum"+rollNum);
		return entityManager.find(College.class, rollNum);
	}

	@Override
	public List<College> findByAddress(String address) {
		// TODO Auto-generated method stub
		System.out.println("find details using address"+address);
		Query q = entityManager.createQuery("select c from College as c where c.address=:add");
		q.setParameter("add", address);
		return q.getResultList();
	}

	@Override
	public  List<College> findAllDetailsfromInMemory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public College findDtailsUsingERollNumInMemory(int rollNum) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
