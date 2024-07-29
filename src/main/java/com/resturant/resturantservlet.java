package com.resturant;

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

@WebServlet("/resturant")
public class resturantservlet extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int resturantid =  (int) req.getAttribute("resturantid");
		
		Menu M = new Menu();
		menuimp mi = new menuimp();
		
		List<Menu> mli = mi.getAll(resturantid);
		
		
		
		req.setAttribute("resturantid", resturantid);
		req.setAttribute("menu", mli);
		RequestDispatcher rd = req.getRequestDispatcher("resturant.jsp");
		rd.forward(req, res);
		
		
		
		
		
		
		
		
		
//		req.setAttribute("resturantid", resturantid);
//		RequestDispatcher rd = req.getRequestDispatcher("uniquerest");
//		rd.forward(req, res);
		
	}

}
