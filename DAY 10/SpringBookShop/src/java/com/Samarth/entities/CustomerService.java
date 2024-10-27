package com.Samarth.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Samarth.contracts.CustomerDaoable;
import com.Samarth.contracts.CustomerServicable;
import com.Samarth.models.Credentials;

@Service
public class CustomerService implements CustomerServicable {
	@Autowired
	private CustomerDaoable custDao;
	
	@Override
	public Customer authenticate(Credentials cr) {
		Customer dbCust = custDao.findByEmail(cr.getEmail());
		if(dbCust != null && dbCust.getCustPsswd().equals(cr.getPassword()))
			return dbCust;
		return null;
	}
}