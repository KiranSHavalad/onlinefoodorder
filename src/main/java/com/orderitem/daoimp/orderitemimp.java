package com.orderitem.daoimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.orderitem.dao.orderitemdao;
import com.orderitem.model.Orderitem;

public class orderitemimp implements orderitemdao {
	static Connection con;
	static String url = "jdbc:mysql://localhost:3306/food";
	static String user = "root";
	static String pass = "root";
	static String query1 = "insert into orderitem(orderid,menuid,quantity,totalprice) values(?,?,?,?)";
	static String query2 = "select * from orderitem where orderitemid=?";
	static String query3 = "select * from orderitem";
	static String query4 = "update orderitem set quantity = ? where orderitemid=?";
	static String query5 = "delete from orderitem where orderitemid=?";
	
	public orderitemimp() {
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
	public int save(Orderitem oi) {
		try {
			PreparedStatement pr = con.prepareStatement(query1);
			pr.setInt(1, oi.getOderid());
			pr.setInt(2, oi.getMenuid());
			pr.setInt(3, oi.getQuantity());
			pr.setInt(4, oi.getTotalprice());
			return pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Orderitem get(int orderitemid) {
		Orderitem oi = null;
		try {
			PreparedStatement pr = con.prepareStatement(query2);
			pr.setInt(1, orderitemid);
			ResultSet res = pr.executeQuery();
			while(res.next()) {
				oi = new Orderitem();
				oi.setOrderitemid(res.getInt("orderitemid"));
				oi.setOderid(res.getInt("orderid"));
				oi.setMenuid(res.getInt("menuid"));
				oi.setQuantity(res.getInt("quantity"));
				oi.setTotalprice(res.getInt("totalprice"));
			}
			return oi;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Orderitem> getAll() {
	    List<Orderitem> list = new ArrayList<Orderitem>();
	    try {
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(query3);
			while(res.next()) {
				Orderitem oi = new Orderitem();
				oi.setOrderitemid(res.getInt("orderitemid"));
				oi.setOderid(res.getInt("orderid"));
				oi.setMenuid(res.getInt("menuid"));
				oi.setQuantity(res.getInt("quantity"));
				oi.setTotalprice(res.getInt("totalprice"));
				list.add(oi);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return null;
	}

	@Override
	public int update(Orderitem oi) {
		try {
			PreparedStatement pr = con.prepareStatement(query4);
			pr.setInt(1,oi.getOrderitemid());
			return pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(int orderitemid) {
		PreparedStatement pr;
		try {
			pr = con.prepareStatement(query5);
			pr.setInt(1, orderitemid);
			return pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return 0;
	}
	
	
	

}
