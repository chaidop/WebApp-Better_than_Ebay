package com.example.web;
import java.io.*;  
import java.util.*;
import java.sql.*;
import javax.servlet.*;  
import javax.servlet.http.*; 
import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
  
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

public class ProductServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// JDBC driver name and database URL
	   final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   final String DB_URL = "jdbc:mysql://localhost/Products";
		
	   //  Database credentials
	   final String USER = "user";
	   final String PASS = "12345";
	   
	   
		String bc = request.getParameter("barcode");
		String c = request.getParameter("color");
		String nm = request.getParameter("name");
		String dc = request.getParameter("description");
		List result;
		
		try{
				  //STEP 2: Register JDBC driver
				  Class.forName("com.mysql.jdbc.Driver");

				  //STEP 3: Open a connection
				  //System.out.println("Connecting to database...");
				  Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

				  //STEP 4: Execute a query
				  //System.out.println("Creating statement...");
				  Statement stmt = conn.createStatement();
				  String sql;
				  sql = "SELECT barcode FROM Products";
				  ResultSet rs = stmt.executeQuery(sql);

				  //STEP 5: Extract data from result set
				//check if product already in database
				  if(rs.next()){
					 //return error message
					/*Dictionary result = Dictionary();
					result.put("barcode",bc);
					result.put("color",c);
					result.put("name",nm);
					result.put("description","::ERROR:: The product with barcode ",barcode,"already exists...");*/
					
				  }
				  else{
					  //adds new item to database
					sql = "INSERT INTO Products VALUES (bc,c,nm,dc);";
					stmt.executeQuery(sql);
					DIrectory item = DIrectory();
					
					item.put("barcode",bc);
					item.put("color",c);
					item.put("name",nm);
					item.put("description",dc);
					result.add(item);
				  }
				  //STEP 6: Clean-up environment
				  rs.close();
				  stmt.close();
				  conn.close();
				  
			   }catch(SQLException se){
				  //Handle errors for JDBC
				  se.printStackTrace();
			   }catch(Exception e){
				  //Handle errors for Class.forName
				  e.printStackTrace();
			   }finally{
				  //finally block used to close resources
				  try{
					 if(stmt!=null)
						stmt.close();
				  }catch(SQLException se2){
				  }// nothing we can do
				  try{
					 if(conn!=null)
						conn.close();
				  }catch(SQLException se){
					 se.printStackTrace();
				  }//end finally try
		   }//end try
		//connect to the jsp->it will take care of reating the new html page 
		//with the information our servlet gives it through the request object
		request.setAttribute("styles", result);
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
	}
}