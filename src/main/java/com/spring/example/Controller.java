package com.spring.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	public CarParts honda;
	
	public static void main(String arg[]) {
		Controller c = new Controller();
		c.display();
	}
	
	public void display() {
		System.out.println(honda.getName());
	}
	
}
