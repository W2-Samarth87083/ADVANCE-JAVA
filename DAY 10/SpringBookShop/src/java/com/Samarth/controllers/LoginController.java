package com.Samarth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.Samarth.contracts.CustomerServicable;
import com.Samarth.entities.Customer;
import com.Samarth.models.Credentials;

@Controller
public class LoginController {
	@Autowired
	private CustomerServicable cServicable;
	
	public String authenticate(Credentials cr) {
		Customer cust = cServicable.authenticate(cr);
		if(cust == null)
			return "failed";
		return "welcome";
	}
}
