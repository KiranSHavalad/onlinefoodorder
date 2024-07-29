package com.reg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.imp.userimp;
import com.rest.daoimp.Resturantimp;
import com.rest.model.Resturant;
import com.userpackage.user;
@WebServlet("/registrationServlets")
public class registrationServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String role = req.getParameter("role");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
//		String role = req.getParameter("role");
		Resturant rr = new Resturant();
		
		long ph = Long.parseLong(phone);
//		if("admin".equals(role)) {
//
//			String cusinetype = null;
//			String isactive = null;
//			int eta = 0;
//			int userid = 0;
//			String imagepath = null;
//			float rating = 0;
//			
//			getServletContext().setAttribute("email", email);
//			
//			getServletContext().setAttribute("pass", password);
//			res.sendRedirect("addresturant");
//			
//			
////			Resturant r = new Resturant(name,address,ph,rating,cusinetype,isactive,eta,userid,imagepath,email,password);
////			Resturantimp ri = new Resturantimp();
////			ri.save(r);
////			
//		  }
		
			userimp ui = new userimp();
			
			user u = new user(name,email,password,ph,address,role);
			
			ui.save(u);
			
		  

		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.include(req, res);
		
		
	}

}
