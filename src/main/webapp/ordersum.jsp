<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cart.Cartitem" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Summary</title>
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
        padding: 20px;
        background-color: #ffffff;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        border-radius: 5px;
    }
    h2 {
        text-align: center;
        margin-bottom: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
    }
    .total {
        text-align: right;
        margin-top: 20px;
    }
    .buttons {
        text-align: center;
        margin-top: 20px;
    }
    .buttons input {
        padding: 10px 20px;
        margin: 5px;
        border: none;
        background-color: #007bff;
        color: white;
        border-radius: 5px;
        cursor: pointer;
    }
    .buttons input.cancel {
        background-color: #dc3545;
    }
    .buttons input:hover {
        opacity: 0.9;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Thank You for your order</h1>
    <h2>Order Summary</h2>
    <% 
        HashMap<Integer, Cartitem> map = (HashMap<Integer, Cartitem>) request.getAttribute("cartitem");
        if (map != null && !map.isEmpty()) {
    %>
    <table>
        <thead>
            <tr>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <% 
                for (Map.Entry<Integer, Cartitem> entry : map.entrySet()) {
                    Cartitem item = entry.getValue();
            %>
            <tr>
                <td><%= item.getItemname() %></td>
                <td><%= item.getQuantity() %></td>
                <td><%= item.getQprice() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>No items in the cart.</p>
    <% } %>
    <strong>Your address:</strong><%=request.getAttribute("address") %><br>
    <strong>Payment mode:</strong><%=request.getAttribute("payment") %>
    <div class="total">
        <strong>Total: </strong><%= request.getAttribute("total") %>
        
    </div>
    
    
    <div class="buttons">
        <form action="login" method="post" style="display:inline;">
              <input type = "hidden" name = "userid" value="<%=request.getAttribute("userid") %>">
            <input type="submit" value="home" class="cancel" name = "home">
        </form>
    </div>
</div>
</body>
</html>
