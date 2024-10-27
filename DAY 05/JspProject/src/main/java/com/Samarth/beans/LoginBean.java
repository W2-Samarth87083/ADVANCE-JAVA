package com.Samarth.beans;

import com.Samarth.dataaccess.CustomerDataAccess;
import com.Samarth.entities.Customer;

public class LoginBean {
	private String email;
	private String password;
	private Customer cust;

	public LoginBean() {
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public void authenticate() {
		try (CustomerDataAccess obj = new CustomerDataAccess()) {
			Customer dbCust = obj.findByEmail(this.email);
			if (dbCust != null && this.password.equals(dbCust.getCustPsswd()))
				this.cust = dbCust;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
