<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/insertProduct" method="post">
	Product ID: <input type="number" id="pid" name="pid">
	Product Name: <input type="text" id="pname" name="pname">
	Product Quantity: <input type="number" id="qty" name="qty">
	Product Price: <input type="number" id="price" name="price">
	Product Expiry Date: <input type="date" id="expdate" name="expdate">
	Category Id: <input type="number" id="cid" name="cid">
	 <button type="submit" value="submit">Submit</button>
</form>
</body>
</html>