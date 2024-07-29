package com.menu.daoimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.menu.dao.menudao;
import com.menu.model.Menu;

public class menuimp implements menudao {
	
	static Connection con;
	static String url = "jdbc:mysql://localhost:3306/food";
	static String user = "root";
	static String pass = "root";
	static String query1 = "insert into menu(resturantid, itemname, description, price, rating, isavailable, imagepath) values(?,?,?,?,?,?,?)";
	static String query2 = "select * from menu where menuid = ?";
	static String query3 = "select * from menu where resturantid = ?";
	static String query4 = "update menu set itemname = ? where menuid = ?";
	static String query5 = "delete from menu where resturantid = ?";
	
	
	public menuimp() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection(url,user,pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public int save(Menu m) {
		try {
			PreparedStatement pr = con.prepareStatement(query1);
			pr.setInt(1,m.getResturantid());
			pr.setString(2, m.getItemname());
			pr.setString(3, m.getDescription());
			pr.setInt(4,m.getPrice());
			pr.setFloat(5,m.getRating());
			pr.setString(6,m.getIsavailable());
			pr.setString(7, m.getImagepath());
			return pr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Menu get(int menuid) {
		Menu m = null;
		PreparedStatement pr;
		try {
			pr = con.prepareStatement(query2);
			pr.setInt(1, menuid);
			ResultSet res = pr.executeQuery();
			while(res.next()) {
				m = new Menu();
				m.setMenuid(res.getInt("menuid"));
				m.setResturantid(res.getInt("resturantid"));
				m.setItemname(res.getString("itemname"));
				m.setDescription(res.getString("description"));
				m.setPrice(res.getInt("price"));
				m.setRating(res.getFloat("rating"));
				m.setIsavailable(res.getString("isavailable"));
				m.setImagepath(res.getString("imagepath"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

	@Override
	public List<Menu> getAll(int resturantid) {
		List<Menu> list = new ArrayList<>();
		PreparedStatement pr;
		try {
			pr = con.prepareStatement(query3);
			pr.setInt(1, resturantid);
			ResultSet res = pr.executeQuery();
			while(res.next()) {
				
				Menu m = new Menu();
				m = new Menu();
				m.setMenuid(res.getInt("menuid"));
				m.setResturantid(res.getInt("resturantid"));
				m.setItemname(res.getString("itemname"));
				m.setDescription(res.getString("description"));
				m.setPrice(res.getInt("price"));
				m.setRating(res.getFloat("rating"));
				m.setIsavailable(res.getString("isavailable"));
				m.setImagepath(res.getString("imagepath"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int update(Menu m) {
		try {
			PreparedStatement pr = con.prepareStatement(query4);
			pr.setString(1,m.getItemname());
			pr.setInt(2,m.getMenuid());
			return pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(int resturantid) {
		try {
			PreparedStatement pr = con.prepareStatement(query5);
			pr.setInt(1, resturantid);
			return pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
