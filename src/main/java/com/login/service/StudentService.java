package com.login.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.login.beans.Student;
import com.login.database.DatabaseConnection;

public class StudentService {

	private Student student;
	private Connection connection;
	private List<Student> studentList;

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

	public static void main(String[] args) {

		List<Student> list = new StudentService().getAllStudents();

		for (Student student : list) {
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getAge());
			System.out.println(student.getCourse());
			System.out.println("---------");
			
		}

	}

}
