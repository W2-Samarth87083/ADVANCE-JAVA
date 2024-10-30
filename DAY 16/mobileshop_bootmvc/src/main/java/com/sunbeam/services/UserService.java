
package com.sunbeam.services;

import com.sunbeam.entities.User;
import com.sunbeam.models.Credentials;

public interface UserService {
	User authenticate(Credentials cr);
}
