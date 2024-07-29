<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.cart.Cartitem" %>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <div class="container">
    <h2>Order Summary</h2>
    <% 
        HashMap<Integer, Cartitem> map = (HashMap<Integer, Cartitem>) getServletContext().getAttribute("cartitem");
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
    
    <div class="total">
        
        <strong>Total: </strong><%=getServletContext().getAttribute("total") %>
    </div>
    
    
</div>
        
</body>
</html>