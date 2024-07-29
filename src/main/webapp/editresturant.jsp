<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Restaurant</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 300px;
    }
    .container strong {
        display: block;
        margin-bottom: 5px;
    }
    .container input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    .container input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        background-color: #28a745;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    .container input[type="submit"]:hover {
        background-color: #218838;
    }
    .container .goback {
        background-color: #dc3545;
    }
    .container .goback:hover {
        background-color: #c82333;
    }
</style>
</head>
<body>
    <div class="container">
        <form action="addresturant" method="post">
            <strong>Rating</strong>
            <input type="text" name="rating" required>
            <strong>Cusinetype</strong>
            <input type="text" name="cusinetype" required>
            <strong>Is Active</strong>
            <input type="text" name="isactive" required>
            <strong>Eta</strong>
            <input type="text" name="eta" required>
            <strong>Image Path</strong>
            <input type="text" name="imagepath" required>
            <input type="hidden" name="resturantid" value="<%=request.getParameter("resturantid") %>">
            <input type="submit" value="Update">
        </form> 
        <form action="login" >
            <input type="hidden" name="resturantid" value="<%=request.getParameter("resturantid") %>">
            <input type="submit" value="Goback" class="goback" name="Goback">
        </form>
    </div>
</body>
</html>
