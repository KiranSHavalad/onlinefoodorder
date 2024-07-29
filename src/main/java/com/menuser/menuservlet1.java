package com.menuser;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.menu.daoimp.menuimp;
import com.menu.model.Menu;
@WebServlet("/menu")
public class menuservlet1 extends HttpServlet {
	
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String resturantid = req.getParameter("resturantid");
		
		int restid = Integer.parseInt(resturantid);
		
		String uid = req.getParameter("userid");
		int userid = Integer.parseInt(uid);
		
		Menu m = new Menu();
		menuimp mi = new menuimp();
		List<Menu> me = mi.getAll(restid);
		req.setAttribute("userid", userid);
		req.setAttribute("men", me);
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, res);
		
		
		
	}

}
