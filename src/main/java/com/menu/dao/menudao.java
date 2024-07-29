package com.menu.dao;

import java.util.List;

import com.menu.model.Menu;

public interface menudao {

	
	int save(Menu m);
	Menu get(int menuid);
	List<Menu> getAll(int resturantid);
	int update(Menu m);
	int delete(int menuid);
}
