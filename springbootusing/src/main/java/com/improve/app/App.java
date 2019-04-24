package com.improve.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@ComponentScan(basePackages= {"com.improve"})
@EnableJpaRepositories(basePackages= "com.improve.dao")
@EnableAutoConfiguration
@EntityScan(basePackages="com.improve.entity")
public class App {
	
	public static void main(String [] args)
	{
		SpringApplication.run(App.class,args);
	}

}
