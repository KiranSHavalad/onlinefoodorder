package com.order.daoimp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.order.model.Order;
import com.order.dao.orderdao;

public class orderimp implements orderdao {
	
	static Connection con;
	static String url = "jdbc:mysql://localhost:3306/food";
	static String user = "root";
	static String pass = "root";
	static String query1 = "insert into food.order(userid,resturantid,totalamount,status,paymentmode) values(?,?,?,?,?)";
	static String query2 = "select * from food.order where orderid = ?";
	static String query3 = "select * from food.order where resturantid = ?";
	static String query4 = "update food.order set status = ? where orderid=?";
	static String query5=  "delete from food.order where orderid = ?";
	static String query6="select orderid from food.order where userid=?";
	public orderimp() {
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
	public int save(Order or) {
		try {
			PreparedStatement pr = con.prepareStatement(query1);
			pr.setInt(1, or.getUserid());
			pr.setInt(2, or.getResturantid());
			pr.setInt(3, or.getTotalamount());
			pr.setString(4, or.getStatus());
			pr.setString(5, or.getPaymentmode());
			return pr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Order get(int orderid) {
		Order or = null;
		try {
			PreparedStatement pr = con.prepareStatement(query2);
			pr.setInt(1, orderid);
			ResultSet res = pr.executeQuery();
			while(res.next()) {
				or = new Order();
				or.setOrderid(res.getInt("orderid"));
				or.setUserid(res.getInt("userid"));
				or.setResturantid(res.getInt("resturantid"));
				or.setOrderdate(res.getDate("orderdate"));
				or.setTotalamount(res.getInt("totalamount"));
				or.setStatus(res.getString("status"));
				or.setPaymentmode(res.getString("paymentmode"));
			}
			return or;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> getAll(int resturantid) {
		List<Order> list = new ArrayList<Order>();
		
		try {
			PreparedStatement st = con.prepareStatement(query3);
			st.setInt(1, resturantid);
			ResultSet res = st.executeQuery();
			while(res.next())
			{
				Order or = new Order();
				or.setOrderid(res.getInt("orderid"));
				or.setUserid(res.getInt("userid"));
				or.setResturantid(res.getInt("resturantid"));
				or.setOrderdate(res.getDate("orderdate"));
				or.setTotalamount(res.getInt("totalamount"));
				or.setStatus(res.getString("status"));
				or.setPaymentmode(res.getString("paymentmode"));
				list.add(or);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(Order or) {
		try {
			PreparedStatement pr = con.prepareStatement(query4);
			pr.setString(1,or.getStatus());
			pr.setInt(2,or.getOrderid());
			return pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(int orderid) {
		try {
			PreparedStatement pr = con.prepareStatement(query5);
			pr.setInt(1, orderid);
			return pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	

}
