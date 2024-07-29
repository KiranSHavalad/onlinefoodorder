package com.dao.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.userdao;
import com.userpackage.user;

public class userimp implements userdao {
	
	static Connection con;
	static String url = "jdbc:mysql://localhost:3306/food";
	static String user = "root";
	static String pass = "root";
	static String query1 = "insert into user(name,email,password,phone,address,role) values(?,?,?,?,?,?)";
	static String query2 = "select * from user where id = ?";
	static String query3 = "select * from user";
	static String query4 = "update user set address=? where id=?";
	static String query5 = "delete from user where email=?";
	static String query6 = "select * from user where email = ? AND password = ?";
	static String query7 = "update user set lastlogindate = ? where email = ?";
	static String query8 = "select id from user where email = ? And password = ?";
	static String query9 = "select name from user where id=?";
	static String query10 = "select address from user where id=?";
	static String query11 = "select phone from user where id=?";
	
	
	public userimp() {
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
	public int save(user u) {
	    try {
	    	PreparedStatement prt = con.prepareStatement(query1);
	    	
	    	String name = u.getName();
	    	String email = u.getEmail();
	    	String password = u.getPassword();
	    	long phone = u.getPhone();
	    	String address = u.getAddress();
	    	String role = u.getRole();
//	    	Date createdDate = u.getCreatedDate();
//	    	Date lastloginDate = u.getLastloginDate();
	    	prt.setString(1, name);
	    	prt.setString(2, email);
	    	prt.setString(3, password);
	    	prt.setLong(4, phone);
	    	prt.setString(5, address);
	    	prt.setString(6, role);
//	    	prt.setDate(7, (java.sql.Date) createdDate);
//	    	prt.setDate(8, (java.sql.Date) lastloginDate);
	    	return prt.executeUpdate();
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public user get(int id) {
		user u = null;
		try {
			PreparedStatement st = con.prepareStatement(query2);
			st.setInt(1, id);
			ResultSet res = st.executeQuery();
			
			if(res.next()) {
				u = new user();
				u.setId(res.getInt("id"));
				u.setName(res.getString("name"));
				u.setEmail(res.getString("email"));
				u.setPassword(res.getString("password"));
				u.setPhone(res.getLong("phone"));
				u.setAddress(res.getString("address"));
				u.setRole(res.getString("role"));
				u.setCreatedDate(res.getDate("createdDate"));
				u.setLastloginDate(res.getDate("lastloginDate"));
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<user> getAll() {
		List<user> list  = new ArrayList<>();
		
		try {
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(query3);
			
			
			while(res.next()) {
				user u = new user();
				u.setId(res.getInt("id"));
				u.setName(res.getString("name"));
				u.setEmail(res.getString("email"));
				u.setPassword(res.getString("password"));
				u.setPhone(res.getLong("phone"));
				u.setAddress(res.getString("address"));
				u.setRole(res.getString("role"));
				u.setCreatedDate(res.getDate("createdDate"));
				u.setLastloginDate(res.getDate("lastloginDate"));
				list.add(u);
			}
			return list;
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int update(user u) {
		try {
			PreparedStatement st = con.prepareStatement(query4);
			st.setString(1,u.getAddress());
			st.setInt(2,u.getId());
			int i = st.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(String email) {
		try {
			PreparedStatement pr = con.prepareStatement(query5);
			pr.setString(1, email);
			int i = pr.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public boolean getUp(String email,String password) {
		boolean t = false;
		user u = null;
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


	@Override
	public int updatelastlogindate(String email) {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		try {
			PreparedStatement pr = con.prepareStatement(query7);
			pr.setTimestamp(1, timestamp);
			pr.setString(2, email);
			return pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getid(String email,String password) {
		user u = null;
		int userid = -1;
		PreparedStatement pr;
		try {
			pr = con.prepareStatement(query8);
			pr.setString(1, email);
			pr.setString(2, password);
			ResultSet res = pr.executeQuery();
			while(res.next()) {
			userid = res.getInt("id");
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return userid;
		
	}
	public String getName(int id) {
		String name="";
		try {
			PreparedStatement pr = con.prepareStatement(query9);
			pr.setInt(1, id);
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
	public String getAddress(int id) {
		String address="";
		try {
			PreparedStatement pr = con.prepareStatement(query10);
			pr.setInt(1, id);
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
	public long getPhone(int id) {
		long phone=-1;
		try {
			PreparedStatement pr = con.prepareStatement(query11);
			pr.setInt(1, id);
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
