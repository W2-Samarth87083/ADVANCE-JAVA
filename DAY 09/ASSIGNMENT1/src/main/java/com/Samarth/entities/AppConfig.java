package com.Samarth.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Samarth.contracts.Accountable;

@Configuration
public class AppConfig {

	@Bean
	public Accountable accBean() {
		Accountable obj=new Account("SBIN12345","Saving",1000.0,null);
		return obj;
	}
}
