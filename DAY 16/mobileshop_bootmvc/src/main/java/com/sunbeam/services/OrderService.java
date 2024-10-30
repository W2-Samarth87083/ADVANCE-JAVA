

package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Mobile;
import com.sunbeam.entities.Order;

public interface OrderService {
	Order addOrder(int userId, int mobileId);
	List<Mobile> findOrderedMobilesByUserId(int id);
}
