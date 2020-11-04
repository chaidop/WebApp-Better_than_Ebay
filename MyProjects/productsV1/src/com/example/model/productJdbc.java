package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class productJdbc {
    public int registerProduct(product pr) throws ClassNotFoundException{
        String INSERT_USERS_SQL = "INSERT INTO productInfo" +
            "  (barcode, name, colour, description) VALUES " +
            " (?, ?, ?, ?);";

        int result = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root", "mp08051999");

            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL);

            preparedStatement.setInt(1, pr.getBarcode());
            preparedStatement.setString(2, pr.getName());
            preparedStatement.setString(3, pr.getColour());
            preparedStatement.setString(4, pr.getDescription());

            result = preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
