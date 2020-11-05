<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.example.model.Products" %>
<!DOCTYPE html>
<html>
<body>
    <head>
        <title>
        <% Products result  = (Products)request.getAttribute("styles");
        if(result.getSuccessCode() != 0){%>
            Product Registered :)
            <%}
        else{%>
        	Product failed to be registered
        	<%} %>
        </title>
        <style>
			body{
				background-image:url('astronomy.jpg');
				background-color:magenta;
				text-shadow:2px 2px 5px grey;
				color: white;
			}

			.special{
				margin: auto;
				width: 50%;
				border: 3px solid pink;
				padding: 10px;
			}
		</style>
    </head>
<p>
	<%
	if (result.getSuccessCode() == 0){%>
	<h1 align="center">PROBLEM LOADING YOUR PAGE</h1><%
		out.print("<br>ERROR: A product with the same barcode already exists. Please try again...");
		
	}
	else{
	%>
	<h1 align="center">
		Product has been inserted!
	</h1>
	<div class="special" align="center">
	<%
	out.print("Barcode: " + result.getBarcode() + "<br>Name: "+ result.getName() +"<br>Color: " + result.getColor()+"<br>Description: " + result.getDescription());
	}
	%>
	</div>
	<br>
	<div align="center" >
	<a href="form.html">Submit another one</a>
	</div>
</body>
</html>