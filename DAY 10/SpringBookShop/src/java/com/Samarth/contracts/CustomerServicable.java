package com.Samarth.contracts;

import com.Samarth.entities.Customer;
import com.Samarth.models.Credentials;

public interface CustomerServicable {
	Customer authenticate(Credentials cr);
}
