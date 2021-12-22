//package com.spring;
//
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurity extends WebSecurityConfigurerAdapter{
//
////	@Autowired
////	public DbProperties dbProperties;
//	
//	@Autowired
//	DataSource dataSource;
//	
//	//example with in memory daa
////	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		// TODO Auto-generated method stub
////		auth.inMemoryAuthentication()
////			.withUser("shekhar")
////			.password("admin")
////			.roles("user")
////			.and()
////			.withUser("admin")
////			.password("admin")
////			.roles("ADMIN");
////	}
//	
//	
//	
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication()
//			.dataSource(dataSource)
//			.usersByUsernameQuery(
//	        		   "select username,password, enabled from users where username=?")
//	        .authoritiesByUsernameQuery(
//	           "select username,role from user_roles where username=?");
//	}
//	
//	//example with database	
////		@Bean
////		public DataSource dataSource() {
////			DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
////			driverManagerDataSource.setDriverClassName(dbProperties.getDriver());
////			driverManagerDataSource.setUrl(dbProperties.getUrl());
////			driverManagerDataSource.setUsername(dbProperties.getUsername());
////			driverManagerDataSource.setPassword(dbProperties.getPassword());
////			return driverManagerDataSource;
////		}
////	
////	@Bean(name = "dataSource")
////	public DriverManagerDataSource dataSource() {
////		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
////		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
////		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/ecispringboot");
////		driverManagerDataSource.setUsername("root");
////		driverManagerDataSource.setPassword("Dell@123");
////		return driverManagerDataSource;
////	}
//	
//	
////	  @Bean public PasswordEncoder gePasswordEncoder() { 
////		  return NoOpPasswordEncoder.getInstance(); 
////	  }
//	 
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/findalldetails").hasRole("ADMIN")
//			.antMatchers("/").hasAnyRole("USER")
//			.and()
//			.formLogin();
//	}
//}
