package com.ordersum;
import com.order.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.Cartitem;
import com.order.daoimp.orderimp;
import com.order.model.Order;
import com.orderhistory.daoimp.orderhistorydaoimp;
import com.orderhistory.model.Orderhistory;

@WebServlet("/ordersum")
public class ordersumservlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		HashMap<Integer,Cartitem> cr =(HashMap<Integer,Cartitem>) getServletContext().getAttribute("cartitem");
		
		
		String itemname= "";
		
		
		int total = 0;
		
		String action = req.getParameter("action");
		String address = req.getParameter("address");
		String payment = req.getParameter("payment");
		
		
		for(Map.Entry<Integer, Cartitem> entry : cr.entrySet()) {
			Cartitem item = entry.getValue();
			total = total + item.getQprice();
			itemname = itemname + item.getItemname();
		}
		
		getServletContext().setAttribute("total", total);
		
		
		
		
		
		
//		if("confirm".equals(action)) {
//			String uid = req.getParameter("userid");
//		    userid = Integer.parseInt(uid);
//			getServletContext().setAttribute("cartitem", cr);
//			getServletContext().setAttribute("total", total);
//            res.sendRedirect("confirm.jsp");
//        	return;
//		}else if("cancel".equals(action)) {
//			res.sendRedirect("cart.jsp");
//		}
//		
		
		
		
		String resturantid = "";
		int totalamount = 0;
 		
		for(Map.Entry<Integer,Cartitem> entry : cr.entrySet()) {
			Cartitem item = entry.getValue();
			resturantid = resturantid + item.getResturantid();
			totalamount = totalamount + item.getQprice();
		}
		int restid = Integer.parseInt(resturantid);
		
		
//		String uid = req.getParameter("userid");
//		int userid = Integer.parseInt(uid);
		
		String status = "pending";
		
//		Order or = new Order(userid,restid,total,status,payment);
//		orderimp oi = new orderimp();
//		
//		oi.save(or);
		
		
		if("confirm".equals(action)) {
//			String uid = req.getParameter("userid");
//		    userid = Integer.parseInt(uid);
//		    orderimp oi = new orderimp();
//		    Order or = new Order(userid,restid,totalamount,"pending",payment);
//			oi.save(or);
			getServletContext().setAttribute("cartitem", cr);
			getServletContext().setAttribute("total", total);
            res.sendRedirect("confirm.jsp");
            return; 
		}else if("cancel".equals(action)) {
			res.sendRedirect("cart.jsp");
		}
		String uid = req.getParameter("userid");
	     int  userid = Integer.parseInt(uid);
		
	    orderimp oi = new orderimp();
	    Order or = new Order(userid,restid,totalamount,"pending",payment);
		Orderhistory oh = new Orderhistory(userid,itemname,totalamount,status);
		orderhistorydaoimp ohi = new orderhistorydaoimp();
		ohi.save(oh);
		
		
		
		
		req.setAttribute("userid", userid);
		req.setAttribute("payment", payment);
		req.setAttribute("address",address);
		req.setAttribute("cartitem", cr);
		req.setAttribute("total", total);
		RequestDispatcher ri = req.getRequestDispatcher("ordersum.jsp");
		ri.forward(req, res);
		
		
		
			}

}
