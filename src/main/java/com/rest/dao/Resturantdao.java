package com.rest.dao;

import java.util.List;

import com.rest.model.Resturant;

public interface Resturantdao {
	
	int save(Resturant rest);
	Resturant get(int resturantid);
	List<Resturant> getAll();
	int update(Resturant rest);
	int delete(int resturantid);
	boolean getUp(String email,String password);
	int getId(String email,String password);
	int updateR(float rating,String cusinetype,String isactive,int eta,String imagepath,int resturantid);
	String getName(int resturantid);
	String getAddress(int resturantid);
	long getPhone(int resturantid);
	

}
