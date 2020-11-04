package com.example.dao;
import java.sql.*;

import com.example.model.Products;

public class ProductsDao {
	int result;
	public int registerPRoduct(Products product)throws ClassNotFoundException{
		String INSERT_QUERY = "INSERT INTO items"+
							" (barcode, name, color, description) VALUES "+
							" (?,?,?,?);";
		Class.forName("com.mysql.jdbc.Driver");
		try (
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false","root","root");
			PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY)){
			
			stmt.setString(1, product.getBarcode());
			stmt.setString(2, product.getName());
			stmt.setString(3, product.getColor());
			stmt.setString(4, product.getDescription());
			
			String sql;
			sql = "SELECT * FROM Products WHERE barcode='"+product.getBarcode()+"'";
			ResultSet rs = stmt.executeQuery(sql);
			//check if product already in database
			 if(!rs.next()){
				 result = -1;
			 }
			//execute the query
			result = stmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

}

