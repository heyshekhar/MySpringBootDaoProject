package com.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.pojo.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> {

	public List<College> findByAddress(String address);
	
	@Query("select c from College as c where c.address=:add") 
	public List<College> myComplexMethodQuery(@Param("add") String add);
}
