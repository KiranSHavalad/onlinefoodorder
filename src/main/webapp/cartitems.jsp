<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cart.Cartitem" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Cart Items</h2>
        <% 
        HashMap<Integer, Cartitem> map = (HashMap<Integer, Cartitem>)getServletContext().getAttribute("cartitem");
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<Integer, Cartitem> entry : map.entrySet()) {
                    Cartitem item = entry.getValue();
                    
        %>
        <div class="cart-item">
            <p><strong>Item ID:</strong> <%= item.getItemid() %></p>
            <p><strong>Details:</strong> <%= item %></p>
            
            <form action="cart"  style="display:inline;">
             <input type="hidden" name="action" value="update">
                <input type="hidden" name="itemid" value="<%= item.getItemid() %>">
                 <input type="hidden" name="name" value="<%= item.getItemname() %>">
                <input type="hidden" name="quantity" value="<%= item.getQuantity() %>">
                <input type="hidden" name="resturantid" value="<%= item.getResturantid() %>">
                <input type="hidden" name="price" value="<%= item.getPrice() %>">
              <strong>Quantity:</strong><input type="number" name="quant" value="<%= item.getQuantity() %>">
                <button type="submit">Update</button>
            </form>
            <form action="cart"  style="display:inline;">
             <input type="hidden" name="action" value="delete">
                <input type="hidden" name="itemid" value="<%= item.getItemid() %>">
                <input type = "hidden" name = "userid" value = "<%=request.getAttribute("userid") %>">
                <input type="hidden" name="name" value="<%= item.getItemname() %>">
                <input type="hidden" name="quantity" value="<%= item.getQuantity() %>">
                <input type="hidden" name="resturantid" value="<%= item.getResturantid() %>">
                <input type="hidden" name="price" value="<%= item.getPrice() %>">
                <button type="submit" class="delete">Delete</button>
            </form>
        </div>
        <% 
                }
            } else {
        %>
        <p>No items in the cart.</p>
        <% 
            }
        %>
  
</body>
</html>