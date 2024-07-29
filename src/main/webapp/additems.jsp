<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Item</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        margin: 0;
        padding: 20px;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .form-container {
        background: #fff;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        width: 400px;
    }
    .form-container h1 {
        text-align: center;
        color: #333;
    }
    .form-group {
        margin-bottom: 15px;
    }
    .form-group strong {
        display: inline-block;
        margin-bottom: 5px;
    }
    .form-group input[type="text"],
    .form-group input[type="submit"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    .form-group input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        cursor: pointer;
    }
    .form-group input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<div class="form-container">
    <h1>Add Item</h1>
    <form action="additems" method="post">
        <% String restid = request.getParameter("resturantid"); %>
        <input type="hidden" name="resturantid" value="<%=restid%>">
        
        <div class="form-group">
            <strong>Item Name:</strong>
            <input type="text" name="itemname">
        </div>
        
        <div class="form-group">
            <strong>Description:</strong>
            <input type="text" name="description">
        </div>
        
        <div class="form-group">
            <strong>Price:</strong>
            <input type="text" name="price">
        </div>
        
        <div class="form-group">
            <strong>Rating:</strong>
            <input type="text" name="rating">
        </div>
        
        <div class="form-group">
            <strong>Is Available:</strong>
            <input type="text" name="isavailable">
        </div>
        
        <div class="form-group">
            <strong>Image Path:</strong>
            <input type="text" name="imagepath">
        </div>
        
        <div class="form-group">
       
        
            <input type="submit" value="Add">
        </div>
    </form>
    
    <form action = "login" method="post">
    <input type="hidden" name="resturantid" value="<%= request.getParameter("resturantid") %>">
    <input type="submit" value="Goback" name="Goback">
    </form>
    
    
</div>
</body>
</html>
