package com.spring;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket docketApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            //.paths(PathSelectors.ant("/api/*"))
	            .apis(RequestHandlerSelectors.basePackage("com.spring"))
	            .build()
	            .apiInfo(getApiDetails());
	            //.useDefaultResponseMessages(false)
	            //.forCodeGeneration(true);
	}
	
	@SuppressWarnings("deprecation")
	private ApiInfo getApiDetails() {
		
		return new ApiInfoBuilder()
				.title("Address book API")
				.description("Sample API of spring swagger tutorial")
				.version("2.9")
				.termsOfServiceUrl("Anyone can access")
				.license("No license")
				.contact(new Contact("shekhar rathore", "http://www.shekharrathore.com", "shekhar@gmail.com"))
				.build();
				
//		return new ApiInfo(
//				"Address book API", 
//				"Sample API of spring swagger tutorial",
//				"2.9",
//				"Anyone can access", 
//				"Shekhar rathore", 
//				"Open for all", 
//				"http://www.apache.org");
	}
	
//	new Contact("shekhar rathore", "http://www.shekharrathore.com", "shekhar@gmail.com")
}
