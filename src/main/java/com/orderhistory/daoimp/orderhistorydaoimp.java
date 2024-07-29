package com.orderhistory.daoimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.orderhistory.dao.orderhistorydao;
import com.orderhistory.model.Orderhistory;

public class orderhistorydaoimp implements orderhistorydao {
	static Connection con;
	static String url = "jdbc:mysql://localhost:3306/food";
	static String user = "root";
	static String pass = "root";
	static String query1 = "insert into orderhistory(userid,itemname,totalamount,status) values(?,?,?,?)";
	static String query2 = "select * from orderhistory where orderhistoryid=?";
	static String query3 = "select * from orderhistory where userid = ?";
	static String query4 = "update orderhistory set status = ? where orderhistoryid = ?";
	static String query5 = "delete from orderhistory where orderhistoryid=?";
	
    public orderhistorydaoimp() {
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
	public int save(Orderhistory oh) {
		try {
			PreparedStatement pr = con.prepareStatement(query1);
			pr.setInt(1, oh.getUserid());
			pr.setString(2, oh.getItemname());
			pr.setInt(3,oh.getTotalamount());
			pr.setString(4, oh.getStatus());
			return pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		return 0;
	}

	
	
	@Override
	public Orderhistory get(int orderhistoryid) {
		Orderhistory oh = null;
		try {
			PreparedStatement pr = con.prepareStatement(query2);
			pr.setInt(1, orderhistoryid);
			ResultSet res = pr.executeQuery();
			while(res.next()) {
				oh = new Orderhistory();
				oh.setOrderhistoryid(res.getInt("orderhistoryid"));
				oh.setUserid(res.getInt("userid"));
				oh.setItemname(res.getString("itemname"));
				oh.setOrderdate(res.getDate("orderdate"));
				oh.setTotalamount(res.getInt("totalamount"));
				oh.setStatus(res.getString("status"));
			}
			return oh;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Orderhistory> getAll(int userid) {
		List<Orderhistory> list = new ArrayList<Orderhistory>();
		Statement st;
		try {
			PreparedStatement pr = con.prepareStatement(query3);
			pr.setInt(1, userid);
			ResultSet res = pr.executeQuery();
			while(res.next()) {
				Orderhistory oh = new Orderhistory();
				oh.setOrderhistoryid(res.getInt("orderhistoryid"));
				oh.setUserid(res.getInt("userid"));
				oh.setItemname(res.getString("itemname"));
				oh.setOrderdate(res.getDate("orderdate"));
				oh.setTotalamount(res.getInt("totalamount"));
				oh.setStatus(res.getString("status"));
				list.add(oh);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public int update(Orderhistory oh) {
		try {
			PreparedStatement pr = con.prepareStatement(query4);
			pr.setString(1,oh.getStatus());
			pr.setInt(2, oh.getOrderhistoryid());
			return pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int orderhistoryid) {
		try {
			PreparedStatement pr = con.prepareStatement(query5);
			pr.setInt(1, orderhistoryid);
			return pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
