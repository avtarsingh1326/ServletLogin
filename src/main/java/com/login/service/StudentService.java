package com.login.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.beans.Student;
import com.login.database.DatabaseConnection;

public class StudentService {

	private Student student;
	private Connection connection;
	private List<Student> studentList;
	private boolean flag;

	public List<Student> getAllStudents() {

		try {
			connection = DatabaseConnection.initializeDatabase();

			PreparedStatement preparedStatement = connection.prepareStatement("select * from student");

			ResultSet resultSet = preparedStatement.executeQuery();

			studentList = new ArrayList<Student>();

			while (resultSet.next()) {
				student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setName(resultSet.getString("name"));
				student.setAge(resultSet.getInt("age"));
				student.setCourse(resultSet.getString("course"));
				studentList.add(student);
			}

		} catch (Exception e) {

		} finally {
			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return studentList;
	}
	
	
	
	public boolean addUserDetails(Student student) {
		
		try {
			connection = DatabaseConnection.initializeDatabase();
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into student(name,age,course) values (?,?,?)");
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getCourse());
			
			int rowCount = preparedStatement.executeUpdate();
			if(rowCount > 0) flag= true;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}
	
	
	public boolean deleteUserByUserId(int userId) {
		
		try {
			connection = DatabaseConnection.initializeDatabase();
			
			PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id=?");
			
			preparedStatement.setInt(1, userId);
			
			int rowCount = preparedStatement.executeUpdate();
			if(rowCount > 0) flag= true;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return flag;
	}
	
	
	
public Student getUserByUserId(int userId) {
		
		try {
			connection = DatabaseConnection.initializeDatabase();
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from student where id=?");
			
			preparedStatement.setInt(1, userId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			student = new Student();
			while(resultSet.next()) {
				student.setId(resultSet.getInt("id"));
				student.setName(resultSet.getString("name"));
				student.setAge(resultSet.getInt("age"));
				student.setCourse(resultSet.getString("course"));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return student;
	}
	
public boolean updateUserByUserId(Student student) {
	
	try {
		connection = DatabaseConnection.initializeDatabase();
		
		PreparedStatement preparedStatement = connection.prepareStatement("update student set name=?, age=?, course=? where id=?");
		
		preparedStatement.setString(1, student.getName());
		preparedStatement.setInt(2, student.getAge());
		preparedStatement.setString(3, student.getCourse());
		preparedStatement.setInt(4, student.getId());
		
		int rowCount = preparedStatement.executeUpdate();
		
		if(rowCount > 0) {
			flag=true;
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	return flag;
}
	

	public static void main(String[] args) {

		Student student = new Student();
		student.setName("Test");
		student.setAge(12);
		student.setCourse("CPCM");
		new StudentService().addUserDetails(student);

	}

}
