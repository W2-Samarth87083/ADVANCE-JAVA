package com.Samarth.contracts;

import java.util.List;

import com.Samarth.entities.Customer;

public interface CustomerDaoable {
	public List<Customer> findAllCustomer();
	public Customer findByEmail(String email);
	public int save(Customer c);
}
