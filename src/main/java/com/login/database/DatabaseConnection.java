package com.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    private static PreparedStatement st;

	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        // Initialize all the information regarding Database Connection
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";
        // Database name to access
        String dbName = "application";
        String dbUsername = "root";
        String dbPassword = "password";

        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName +"?serverTimezone=America/New_York", dbUsername, dbPassword);
        return con;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;
        try {
            con = initializeDatabase();
           
            st = con.prepareStatement("select * from user_login");
           
            ResultSet resultSet = st.executeQuery();
            
            while (resultSet.next()) {
				System.out.println(resultSet.getString("username"));
				System.out.println(resultSet.getString("password"));
			}
            
            
        } catch (ClassNotFoundException | SQLException e) {
        	System.out.println("Message "+e.getMessage());
            e.printStackTrace();
            // Handle the exceptions appropriately
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Handle the closing exception if necessary
                }
            }
        }
    }
}
