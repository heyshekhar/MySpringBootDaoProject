package com.spring.controller;

import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.business.CollegeOperation;
import com.spring.dao.CollegeRepository;
import com.spring.pojo.College;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.vertx.core.json.JsonObject;

@Api(value = "this is the college example on spring", description = "show college swagger UI api example")
@RestController
@RequestMapping("/api/college")
public class CollegeUI {

//	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${student.name:}")
	private String studentName;
	
	@Value("${student.surname}")
	private String studentSurName;
	
	@Autowired
	private CollegeOperation collegeOperation;

	@PostConstruct
	public void setup() {
		College clg = new College();
		clg.setRollNumber(10);;
		clg.setAddress("korba");
		collegeOperation.addInMemoryDetails(clg);
	}
	
	@GetMapping(value = "/welcome")
	public String welcomeMessage() {
		return "this is college ms example";
	}
	
	public void startTask() {
		int num = 1;
		Scanner sc = new Scanner(System.in);
		while(num == 1) {
			System.out.println("enter the choice to perform the operaiotn "
					+ "1-> add new data, "
					+ "2-> find review by rating , "
					+ "3-> peek,"
					+ "4-> display");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				System.out.print("enter roll number : ");
				int rollNumber = Integer.parseInt(sc.nextLine());
				System.out.print("\nenter address : ");
				String address = sc.nextLine();
				//addCollegeDetails(rollNumber, address);
				break;
			case 2:
				//findRewviewByRating();
				break;
			/*
			 * case 2: pop(); break; case 3: peek; break; 
			 */
			case 4:
				System.out.print("etner the roll number for details : ");
				int rollNum = Integer.parseInt(sc.nextLine());
				//findDetails(rollNum); break;
			default:
				System.out.println("invalid choice");
			}

			System.out.print("want to continue, select 1 for yes 0 for no : ");
			num = Integer.parseInt(sc.nextLine());
		}
		
		
	}
	
	@PostMapping(value = "/findByRollNumber/{rollNumber}")
	public void findDetails(@PathVariable("rollNumber") int rollNum, @RequestParam("name") String number)	{
		System.out.println("trying two path variable : "+number);
//		College details = collegeOperation.findDetails(rollNum);
//		System.out.println("dtails : " +details.getRollNumber()+"  "+details.getAddress());
	}
	
	@PostMapping(value = "/findByRollNumber")
	public College findDetailsUsingRollnumber(@RequestBody String str)	{
//		System.out.println("trying two path variable : "+number);
		
		JsonObject jsonArr = new JsonObject(str);
		int id = Integer.parseInt(jsonArr.getString("id"));
		College details = collegeOperation.findDetails(id);
		System.out.println("dtails : " +details.getRollNumber()+"  "+details.getAddress());
		return details;
	}
	
	@PostMapping(value = "/findByAddress")
	public List<College> findDetailsByAddress(@RequestBody String str)	{
//		System.out.println("trying two path variable : "+number);
		
		JsonObject jsonArr = new JsonObject(str);
		String address = (jsonArr.getString("address"));
		List<College> details = collegeOperation.findByAddress(address);
		//System.out.println("dtails : " +details.getRollNumber()+"  "+details.getAddress());
		return details;
	}
	
	@PostMapping(value ="/addCollegeDetailsOnInMemory")
	public void addCollegeDetails(@RequestBody College college) { 
		System.out.println("request : "+college.getRollNumber() +" addresss:"+college.getAddress());
		int rollnum = collegeOperation.addInMemoryDetails(college);
		System.out.println("added new college details  : " +rollnum);
		System.out.println("student name : "+studentName+"  "+studentSurName);
	}
	
	@GetMapping(value ="/findDtailsUsingERollNumInMemory/{rollNum}")
	public College findDtailsUsingERollNumInMemory(@PathVariable("rollNum") int rollNum) {
		return collegeOperation.findDtailsUsingERollNumInMemory(rollNum);
	}
	
	@GetMapping(value ="/findDtailsUsingERollNumInMemory/")
	public College findDtailsUsingERollNumInMemoryRequest(@RequestParam int rollNum) {
		return collegeOperation.findDtailsUsingERollNumInMemory(rollNum);
	}

	@ApiOperation(value = "find all details on inMemory")
	@GetMapping(value ="/findAllDetailsfromInMemory")
	public List<College> findAllDetailsfromInMemory() {
		return collegeOperation.findAllDetailsfromInMemory();
	}
	
	@ApiOperation(value = "add the value in database")
	@PostMapping("/addCollegeDetailsCurd/{rollNum}")
	public String addCollegeDetailsCurd(@RequestBody College college, @PathVariable("rollNum") int rollNum) {
	//	logger.info("request :"+college.getRollNumber()+    college.getAddress());
//		System.out.println("request :"+college.getRollNumber()+    college.getAddress());
		collegeOperation.addCollegeDetailsCurd(college);
		return college.toString();
	}

	@GetMapping(value = "/findalldetails")
	public List<College> findAllDetails(){
		System.out.println(" admin can check all the data");
		return collegeOperation.findAllDetials();
	}
	
}
