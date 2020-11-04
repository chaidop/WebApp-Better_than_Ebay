<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.example.model.Products" %>
<!DOCTYPE html>
<html>
<body>
    <head>
        <title>
            Product Registered :)
        </title>
    </head>
<p>
	<%
	Products result  = (Products)request.getAttribute("styles");
	if (result.getSuccessCode() == -1){%>
	<h1 align="center">PROBLEM LOADING YOUR PAGE</h1><%
		out.print("<br>ERROR: A product with the same barcode already exists. Please try again...");
		
	}
	else{
	%>
	<h1 align="center">
		Product has been inserted!
	</h1>
	<%
	out.print("result="+result.getSuccessCode()+"<br>Barcode: " + result.getBarcode() + "<br>Name: "+ result.getName() +"<br>Color: " + result.getColor()+"<br>Description: " + result.getDescription());
	}
	%>
	<br><a href="products.html">Submit another one</a>
</body>
</html>
