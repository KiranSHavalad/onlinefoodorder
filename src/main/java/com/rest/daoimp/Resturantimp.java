package com.rest.daoimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rest.dao.Resturantdao;
import com.rest.model.Resturant;
import com.userpackage.user;

public class Resturantimp implements Resturantdao {
	
	static Connection con;
	static String url  = "jdbc:mysql://localhost:3306/food";
	static String user = "root";
	static String pass = "root";
	static String query1= "insert into resturant(name,address,phone,rating,cusinetype,isactive,eta,userid,imagepath,email,password) values(?,?,?,?,?,?,?,?,?,?,?)";
	static String query2 = "select * from resturant where resturantid = ?";
	static String query3 = "select * from resturant";
	static String query4 = "update resturant set eta = ? where resturantid = ?";
	static String query5 = "delete from resturant where resturantid = ?";
	static String query6 = "select * from resturant where email = ? AND password = ?";
	static String query7 = "select resturantid from resturant where email = ? AND password = ?";
	static String query8 = "update resturant set rating = ?,cusinetype=?,isactive=?,eta = ?,imagepath=? where resturantid = ?";
	static String query9 = "select name from resturant where resturantid=?";
	static String query10 = "select address from resturant where resturantid=?";
	static String query11 = "select phone from resturant where resturantid=?";
	public Resturantimp() {
		
		try {
			con = DriverManager.getConnection(url,user,pass);
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public int save(Resturant rest) {
		try {
			url  = "jdbc:mysql://localhost:3306/food";
			user = "root";
			pass = "root";
			con = DriverManager.getConnection(url,user,pass);
			PreparedStatement pr = con.prepareStatement(query1);
			
			pr.setString(1, rest.getName());
			pr.setString(2,rest.getAddress());
			pr.setLong(3, rest.getPhone());
			pr.setFloat(4, rest.getRating());
			pr.setString(5, rest.getCusinetype());
			pr.setString(6, rest.getIsactive());
			pr.setInt(7, rest.getEta());
			pr.setInt(8, rest.getUserid());
			pr.setString(9, rest.getImagepath());
			pr.setString(10, rest.getEmail());
			pr.setString(11, rest.getPassword());
			return pr.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Resturant get(int resturantid) {
	    Resturant rest = null;
	    
	    try {
			PreparedStatement pr = con.prepareStatement(query2);
			pr.setInt(1, resturantid);
			ResultSet res = pr.executeQuery();
			
			while(res.next()) {
				rest = new Resturant();
				
				rest.setResturantid(res.getInt("resturantid"));
				rest.setName(res.getString("name"));
				rest.setAddress(res.getString("address"));
				rest.setPhone(res.getLong("phone"));
				rest.setRating(res.getFloat("rating"));
				rest.setCusinetype(res.getString("cusinetype"));
				rest.setIsactive(res.getString("isactive"));
				rest.setEta(res.getInt("eta"));
				rest.setUserid(res.getInt("userid"));
				rest.setImagepath(res.getString("imagepath"));
				rest.setEmail(res.getString("email"));
				rest.setPassword(res.getString("password"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rest;
	}

	@Override
	public List<Resturant> getAll() {
		 List<Resturant> list = new ArrayList<>();
		try {
			url  = "jdbc:mysql://localhost:3306/food";
			user = "root";
			pass = "root";
			con = DriverManager.getConnection(url,user,pass);
			 Statement st = con.createStatement();
		    ResultSet res = st.executeQuery(query3);
		    
		    while(res.next()) {
		    	Resturant rest = new Resturant();
		    	rest.setResturantid(res.getInt("resturantid"));
				rest.setName(res.getString("name"));
				rest.setAddress(res.getString("address"));
				rest.setPhone(res.getLong("phone"));
				rest.setRating(res.getFloat("rating"));
				rest.setCusinetype(res.getString("cusinetype"));
				rest.setIsactive(res.getString("isactive"));
				rest.setEta(res.getInt("eta"));
				rest.setUserid(res.getInt("userid"));
				rest.setImagepath(res.getString("imagepath"));
				rest.setEmail(res.getString("email"));
				rest.setPassword(res.getString("password"));
				list.add(rest);
		    	
		    }
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		  
		return list;
	}

	@Override
	public int update(Resturant rest) {
		 
		try {
			PreparedStatement pr = con.prepareStatement(query4);
			pr.setInt(1,rest.getEta());
			pr.setInt(2, rest.getResturantid());
			return pr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	
	}

	@Override
	public int delete(int resturantid) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement(query5);
			pr.setInt(1, resturantid);
			return pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return 0;
	}
	public boolean getUp(String email,String password) {
		boolean t = false;
		Resturant u = null;
 		try {
			PreparedStatement pr = con.prepareStatement(query6);
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
	public int getId(String email, String password) {
		int resturantid = -1;
		try {
			PreparedStatement pr = con.prepareStatement(query7);
			pr.setString(1, email);
			pr.setString(2, password);
			ResultSet res = pr.executeQuery();
			while(res.next()) {
				resturantid = res.getInt("resturantid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resturantid;
	}
	
	public int updateR(float rating,String cusinetype,String isactive,int eta,String imagepath,int resturantid) {
		try {
			url  = "jdbc:mysql://localhost:3306/food";
			user = "root";
			pass = "root";
			con = DriverManager.getConnection(url,user,pass);
			PreparedStatement pr = con.prepareStatement(query8);
			pr.setFloat(1,rating );
			pr.setString(2,cusinetype);
			pr.setString(3, isactive);
			pr.setInt(4, eta);
			pr.setString(5, imagepath);
			pr.setInt(6, resturantid);
			return pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public String getName(int resturantid) {
		String name="";
		try {
			PreparedStatement pr = con.prepareStatement(query9);
			pr.setInt(1, resturantid);
			ResultSet res = pr.executeQuery();
			while(res.next()) {
				name = res.getString("name");
			}
			return name;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String getAddress(int resturantid) {
		String address="";
		try {
			PreparedStatement pr = con.prepareStatement(query10);
			pr.setInt(1, resturantid);
			ResultSet res = pr.executeQuery();
			while(res.next()) {
				address = res.getString("address");
			}
			return address;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public long getPhone(int resturantid) {
		long phone=-1;
		try {
			PreparedStatement pr = con.prepareStatement(query11);
			pr.setInt(1, resturantid);
			ResultSet res = pr.executeQuery();
			while(res.next()) {
				phone = res.getLong("phone");
			}
			return phone;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phone;
	}
	

}
