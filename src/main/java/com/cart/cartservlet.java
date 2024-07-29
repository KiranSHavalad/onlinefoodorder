package com.cart;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cart")
public class cartservlet extends HttpServlet {
//	 private static final AtomicInteger counter = new AtomicInteger(0);
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("itemid");
		int itemid = Integer.parseInt(id);
		String name = req.getParameter("name");
		String quantity = req.getParameter("quantity");
		int quan= Integer.parseInt(quantity);
		String price = req.getParameter("price");
		int Pr = Integer.parseInt(price);
		String resturantid = req.getParameter("resturantid");
		int restid = Integer.parseInt(resturantid);
		
//		int itemId = counter.incrementAndGet();
		Cartitem ci = new Cartitem(itemid,name,quan,Pr,restid);
		Cartcreator  cr  = new Cartcreator();
		HashMap<Integer,Cartitem> cm =  cr.additemcart(ci);
		String userid = req.getParameter("userid");
		
		String action = req.getParameter("action");
		
		
		
		int uid = Integer.parseInt(userid);
//////		
		
		 if ("update".equals(action)) {
			 String quant = req.getParameter("quant");
				int qu = Integer.parseInt(quant);
					cr.update(ci,qu);
	        } else if ("delete".equals(action)) {
	        	  cr.delete(cm,itemid);
	        } else if("check".equals(action)) {
	        	
	    		
//	        	getServletContext().setAttribute("userid", uid);
	        	getServletContext().setAttribute("cartitem", cm);
	            res.sendRedirect("ordersum");
	        	return;
	        } else if("cartitems".equals(action)) {
	        	
	        	getServletContext().setAttribute("cartitem", cm);
	        	getServletContext().setAttribute("userid", uid);
	            res.sendRedirect("cartitems");
	        	return;
	        }
		if (cm == null) {
            cm = new HashMap<>();
		}
		
		
		
		getServletContext().setAttribute("cartitem", cm);
        
		
		
		
	     
	     
		
		
		req.setAttribute("userid", uid);
		req.setAttribute("cartitem", cm);
		RequestDispatcher re = req.getRequestDispatcher("cart.jsp");
		
		re.forward(req, res);
		
		
		
//		
        
		
		 
		
		}
		
		
	}


