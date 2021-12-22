package com.spring.example;

import org.springframework.stereotype.Component;

@Component
public class Honda implements CarParts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "honda";
	}
	
	public void display() {
		this.getName();
	}

}
