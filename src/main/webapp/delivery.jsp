<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.deliveryboy.model.deliveryboy" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <% 
    List<deliveryboy> list = (List<deliveryboy>) request.getAttribute("deliveryboy"); 
    if (list != null && !list.isEmpty()) {
        for (deliveryboy db : list) {
        	 	
        	
        	
    %>
    <form action="">
       <p><strong>Name:</strong><%= db.getName() %></p>
        <p><strong>Address:</strong><%= db.getAddress() %></p>
        <p><strong>Phone:</strong><%= db.getPhone() %></p>
        <input type="hidden"   name="id"   value="<%=db.getId() %>">
        <input type="hidden" name="userid" value="<%=request.getAttribute("userid") %>">
         <input type="hidden" name="resturantid" value="<%=request.getAttribute("resturantid") %>">
          <input type="hidden" name="orderdate" value="<%=request.getAttribute("orderdate") %>">
          <input type ="submit" value="select" >
          </form>
     <%  
       }
    } else { 
    %>
    <p class="no-items">No Items</p>
    <% } %>
    
</body>
</html>