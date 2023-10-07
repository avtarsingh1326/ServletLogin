package com.login.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.login.beans.UserLogin;
import com.login.database.DatabaseConnection;

public class LoginService {
	
	private boolean flag;
	private Connection connection;
	private UserLogin userLogin;
	
	public boolean login(String username, String password) {
		
	try {
		connection = DatabaseConnection.initializeDatabase();
		
		PreparedStatement preparedStatement = connection.prepareStatement
				("select * from user_login where username='"+ username +"' and password='"+password+"'");
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			flag = true;
		}
		connection.close();
	}catch (Exception e) {
		System.out.println("Exception Message " + e.getMessage());
		e.printStackTrace();
	}finally {
		try {
			if(connection != null) {
				connection.close();				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}		
		return flag;
	}
	
	
	
	public UserLogin getUserLoginDetails(UserLogin userLogin) {
		
		try {
			connection = DatabaseConnection.initializeDatabase();
			
			PreparedStatement preparedStatement = connection.prepareStatement
					("select * from user_login where username=? and password=?");
			preparedStatement.setString(1, userLogin.getUsername());  //Set Username and password in Query
			preparedStatement.setString(2, userLogin.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			
			this.userLogin = new UserLogin();  // Created a new object to return 
			
			while (rs.next()) {
			this.userLogin.setUsername(rs.getString("username"));   // Pass Coloum name 
			this.userLogin.setPassword(rs.getString("password"));
			}
			connection.close();
		}catch (Exception e) {
			System.out.println("Exception Message " + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();				
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}		
			return this.userLogin;
		}
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println(new LoginService().login("avtar", "password"));
		
	}

}
