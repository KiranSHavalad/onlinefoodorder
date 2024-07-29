<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 50%;
        margin: 50px auto;
        padding: 20px;
        background-color: #ffffff;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
    }
    h2 {
        text-align: center;
        margin-bottom: 20px;
    }
    form {
        display: flex;
        flex-direction: column;
    }
    label {
        margin-bottom: 10px;
        font-weight: bold;
    }
    input[type="text"], select {
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    button {
        padding: 10px 20px;
        border: none;
        background-color: #007bff;
        color: white;
        border-radius: 5px;
        cursor: pointer;
        align-self: center;
    }
    button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<div class="container">
    <h2>Order Confirmation</h2>
    <form action="ordersum">
        <label for="address"><strong>Address</strong></label>
        <input type="text" id="address" name="address" required>

        <label for="payment"><strong>Payment Mode</strong></label>
        <select id="payment" name="payment" required>
            <option value="UPI">UPI</option>
            <option value="COD">COD</option>
            <option value="CARD">CARD</option>
        </select>

        <input type="hidden" name="userid" value="<%=request.getParameter("userid") %>">  
        <button type="submit" name="confirm" value="confirm">Confirm</button>
    </form>
</div>
</body>
</html>
