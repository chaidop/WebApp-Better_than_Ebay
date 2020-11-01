<%@ page import=”java.util.*” %>
<html>
<body>

<p>
	<%
	List styles = (List)request.getAttribute(“styles”);
	Iterator it = styles.iterator();
	if(it.hasNext()) {
	it.next();
	<h1 align=”center”>Product has been inserted!</h1>
	out.print(“<br>Barcode: “ + it.get("barcode") + “<br>Name: “ + it.get("name") +“<br>Color: “ + it.get("color")+“<br>Description: “ + it.get("description"));
	}
	else{
		<h1 align=”center”>PROBLEM LOADING YOUR PAGE</h1>
		out.print(“<br>ERROR: A product with the same barcode already exists. Please try again...“);
	}
	%>
</body>
</html>