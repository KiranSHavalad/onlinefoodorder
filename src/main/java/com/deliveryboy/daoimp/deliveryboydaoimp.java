package com.deliveryboy.daoimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.deliveryboy.dao.deliverydao;
import com.deliveryboy.model.deliveryboy;
import com.rest.model.Resturant;

public class deliveryboydaoimp implements deliverydao {
	
	static Connection con;
	static String url = "jdbc:mysql://localhost:3306/food";
	static String user = "root";
	static String pass = "root";
	static String query1 = "insert into deliveryboy(name,phone,address,email,password) values(?,?,?,?,?)";
	static String query2 = "select * from deliveryboy";
	static  String query3= "select * from deliveryboy where email=? AND password=?";
	static String query4="select id from deliveryboy where email =? AND password=?";
	static String query5 = "update deliveryboy set username=?,useraddress=?,userphone=?,resturantname=?,resturantaddress=?,resturantphone=? where id = ?";
			
	public deliveryboydaoimp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	


	@Override
	public boolean getUp(String email,String password) {
		boolean t = false;
		deliveryboy boy = null;
 		try {
			PreparedStatement pr = con.prepareStatement(query3);
			pr.setString(1,email);
			pr.setString(2, password);
			ResultSet res = pr.executeQuery();
			while(res.next()) {
			    t = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
		
	}
	
	
	
	public int getId(String email,String password) {
		  int id = -1;
		try {
			PreparedStatement pr = con.prepareStatement(query4);
			pr.setString(1,email);
			pr.setString(2, password);
			ResultSet res = pr.executeQuery();
			while(res.next()) {
				id = res.getInt("id");
			}
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return 0;
	}
	
	
	public List<deliveryboy> getAll(){
	          List<deliveryboy> list = new ArrayList<deliveryboy>();
	          Statement st;
			try {
				st = con.createStatement();
				ResultSet res = st.executeQuery(query2);
				while(res.next()) {
					deliveryboy boy = new deliveryboy();
					boy.setId(res.getInt("id"));
					boy.setName(res.getString("name"));
					boy.setPhone(res.getLong("phone"));
					boy.setAddress(res.getString("address"));
					list.add(boy);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          
	       return list;   
	          
 		
	}
	public int add(String username,String useraddress,long userphone,String resturantname,String resturantaddress,long resturantphone,int id) {
		
		PreparedStatement pr;
		try {
			pr = con.prepareStatement(query5);
			pr.setString(1, username);
			pr.setString(2, useraddress);
			pr.setLong(3, userphone);
			pr.setString(4,resturantname);
			pr.setString(5,resturantaddress);
			pr.setLong(6, resturantphone);
			pr.setInt(7,id);
			return pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	

}
