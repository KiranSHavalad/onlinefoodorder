package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.UIClientPropertyKey;

import com.dao.imp.userimp;
import com.deliveryboy.daoimp.deliveryboydaoimp;
import com.deliveryboy.model.deliveryboy;
import com.rest.daoimp.Resturantimp;
import com.rest.model.Resturant;
import com.userpackage.user;

/**
 * Servlet implementation class login
 */

public class login extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String pass = req.getParameter("password");

		userimp ui = new userimp();
		user u = new user();
		
		Resturantimp ri = new Resturantimp();
		Resturant r = new Resturant();
		
		deliveryboy boy = new deliveryboy();
		deliveryboydaoimp dimp = new deliveryboydaoimp();
		
		
		String action = req.getParameter("home");
		String action2 = req.getParameter("back");
		String action3=  req.getParameter("Goback");
		PrintWriter pr  = res.getWriter();
		if(ri.getUp(email, pass))
		{
			
			int resturantid = ri.getId(email, pass);
	        req.setAttribute("resturantid", resturantid);
			RequestDispatcher rd = req.getRequestDispatcher("resturant");
			rd.forward(req, res);
				
		} else if(dimp.getUp(email, pass)) {
			
			
			int boyid = dimp.getId(email, pass);
			req.setAttribute("boyid", boyid);
			RequestDispatcher rd = req.getRequestDispatcher("deliveryboy");
			rd.forward(req,res);	
		}
		else if (ui.getUp(email, pass)) {
			
			int id = ui.getid(email, pass);
			ui.updatelastlogindate(email);
			req.setAttribute("userid", id);
			RequestDispatcher rd = req.getRequestDispatcher("home1");
			rd.forward(req, res);	
		} else if("Goback".equals(action3)) {
			String restid = req.getParameter("resturantid");
			int resturantid = Integer.parseInt(restid);
			req.setAttribute("resturantid", resturantid);
			RequestDispatcher rd = req.getRequestDispatcher("resturant");
			rd.forward(req, res);
		}
		
		else if("home".equals(action)) 
		{
			
		  String uid = req.getParameter("userid");
		  int userid = Integer.parseInt(uid);
		  req.setAttribute("userid", userid);
		  RequestDispatcher rd = req.getRequestDispatcher("home1");
		  rd.forward(req, res);	
			
			
		}
		
		
		else if("back".equals(action2)) {
			
			
			String usid =req.getParameter("userid");
			
			int id = Integer.parseInt(usid);
			req.setAttribute("userid", id);
			RequestDispatcher rd = req.getRequestDispatcher("home1");
			rd.forward(req, res);	
		}
		
		
		
		else
		{
			req.setAttribute("errorMessage", "Invalid email or password");
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, res);
		}
	}

}
