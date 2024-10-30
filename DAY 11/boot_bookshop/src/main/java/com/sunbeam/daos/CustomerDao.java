
package com.sunbeam.daos;

import com.sunbeam.entities.Customer;

public interface CustomerDao {
	Customer findByEmail(String email);
	int save(Customer c);
}
