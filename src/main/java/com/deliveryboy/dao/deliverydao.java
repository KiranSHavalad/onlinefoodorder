package com.deliveryboy.dao;

import java.util.List;

import com.deliveryboy.model.deliveryboy;

public interface deliverydao {
	
	boolean getUp(String email,String password);
	int getId(String emai,String password);
	List<deliveryboy> getAll();
	int add(String username,String useraddress,long userphone,String resturantname,String resturantaddress,long resturantphone,int id);
}
