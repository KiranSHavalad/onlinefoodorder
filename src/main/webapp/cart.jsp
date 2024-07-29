<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cart.Cartitem" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 80%;
        margin: 20px auto;
    }
    h2 {
        text-align: center;
        margin-top: 20px;
    }
    .cart-item {
        background-color: #ffffff;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        padding: 15px;
        margin-bottom: 20px;
        border-radius: 5px;
    }
    .cart-item strong {
        display: inline-block;
        width: 120px;
    }
    .cart-item button {
        margin: 5px 0;
        padding: 10px;
        border: none;
        background-color: #007bff;
        color: white;
        border-radius: 5px;
        cursor: pointer;
    }
    .cart-item button.delete {
        background-color: #dc3545;
    }
    .cart-item button:hover {
        opacity: 0.9;
    }
    .home-button {
        display: block;
        text-align: center;
        margin: 20px 0;
    }
    .home-button input {
        padding: 10px 20px;
        border: none;
        background-color: #007bff;
        color: white;
        border-radius: 5px;
        cursor: pointer;
    }
    .home-button input:hover {
        opacity: 0.9;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Cart Items</h2>
        <% 
            HashMap<Integer, Cartitem> map = (HashMap<Integer, Cartitem>) request.getAttribute("cartitem");
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
              <input type = "hidden" name = "userid" value = "<%=request.getAttribute("userid") %>">
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
       
        <div class="home-button">
        <form action = "checkout.jsp?userid="<%=request.getAttribute("userid") %>">

            <input type = "hidden" name = "userid" value = "<%=request.getAttribute("userid") %>">
            
            <input type="submit" value="Checkout" name = "action">
            </form>
        </div>
        
        
        <div class="home-button">
             <form action="login" method="post" style="display:inline;">
            <input type = "hidden" name = "userid" value = "<%=request.getAttribute("userid") %>">
            <input type="submit" value="back" class="cancel" name = "back">
        </div>
    </div>
</body>
</html>
