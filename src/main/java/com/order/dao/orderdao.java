package com.order.dao;

import java.util.List;

import com.order.model.Order;

public interface orderdao {
	
	int save(Order or);
	Order get(int orderid);
	List<Order> getAll(int resturantid);
	int update(Order or);
	int delete(int orderid);
	

}
