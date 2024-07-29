package com.cart;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/cart")
public class cartser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int itemId = Integer.parseInt(request.getParameter("itemid"));
        int resturantid = Integer.parseInt(request.getParameter("resturantid"));
        int price = Integer.parseInt(request.getParameter("price"));
        String name = request.getParameter("itemname");
        

        HttpSession session = request.getSession();
        HashMap<Integer, Cartitem> cart = (HashMap<Integer, Cartitem>) request.getAttribute("cartitem");

        if (cart == null) {
            cart = new HashMap<>();
        }

        if ("update".equals(action)) {
            // Update logic
            int newQuantity = Integer.parseInt(request.getParameter("quant"));
            updateItemInCart(cart, itemId,name, newQuantity, resturantid, price);
        } else if ("delete".equals(action)) {
            // Delete logic
            deleteItemFromCart(cart, itemId);
        }

        // Save the cart back to the session
        request.setAttribute("cartitem", cart);

        // Redirect back to the cart page
        response.sendRedirect("cart.jsp");
    }

    private void updateItemInCart(HashMap<Integer, Cartitem> cart, int itemId,String name, int quantity, int price,int resturantid) {
        if (cart.containsKey(itemId)) {
            Cartitem item = cart.get(itemId);
            item.setQuantity(quantity);
        } else {
            // Handle the case where the item does not exist in the cart
            Cartitem newItem = new Cartitem(itemId,name, quantity,price,resturantid);
            cart.put(itemId, newItem);
        }
    }

    private void deleteItemFromCart(HashMap<Integer, Cartitem> cart, int itemId) {
        cart.remove(itemId);
    }
}

