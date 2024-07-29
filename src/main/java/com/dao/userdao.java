package com.dao;

import java.util.List;

import com.userpackage.user;

public interface userdao {
	
	int save(user u);
	user get(int  id);
	List<user> getAll();
	int update(user u);
	int delete(String email);
	boolean getUp(String email,String password);
	int updatelastlogindate(String email);
	String getName(int id);
	String getAddress(int id);
	long getPhone(int id);
}
