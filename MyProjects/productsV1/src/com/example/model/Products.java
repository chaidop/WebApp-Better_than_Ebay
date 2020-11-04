package com.example.model;
import java.sql.*;

public class Products {
	private String barcode;
	private String name;
	private String color;
	private String description;
	private Integer SuccessCode;
	
	public int registerPRoduct(Products product)throws ClassNotFoundException{
		String INSERT_QUERY = "INSERT INTO items"+
							" (barcode, name, color, description) VALUES "+
							" (?,?,?,?);";
		Class.forName("com.mysql.jdbc.Driver");
		try (
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Products");
			PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY)){
			stmt.setString(1, product.getBarcode());
			stmt.setString(2, product.getName());
			stmt.setString(3, product.getColor());
			stmt.setString(4, product.getDescription());
			
			String sql;
			sql = "SELECT * FROM items WHERE barcode='"+product.getBarcode()+"'";
			ResultSet rs = stmt.executeQuery(sql);
			//check if product already in database
			 if(!rs.next()){
				 SuccessCode = -1;
			 }
			//execute the query
			SuccessCode = stmt.executeUpdate();
			conn.close();
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return SuccessCode;
	}
	
	
	public Integer getSuccessCode() {
		return SuccessCode;
	}
	public void setSuccessCode(Integer successCode) {
		SuccessCode = successCode;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}


