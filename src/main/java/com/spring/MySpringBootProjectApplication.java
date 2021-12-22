package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.controller.CollegeUI;

@SpringBootApplication
public class MySpringBootProjectApplication {
 
	public static void main(String[] args) {
		
		SpringApplication.run(MySpringBootProjectApplication.class, args);
//		ApplicationContext springContainer = SpringApplication.run(MySpringBootProjectApplication.class, args);
		/*
		 * College college = springContainer.getBean(College.class);
		 * System.out.println("spring boot end successfully......!!!!");
		 * college.display();
		 */
		
		/*
		 * CollegeUI college = springContainer.getBean(CollegeUI.class);
		 * 
		 * college.startTask();
		 */
		//college.display();
	}
}
