package com.login.serlvet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.login.beans.Constants;
import com.login.beans.Student;
import com.login.service.StudentService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
@MultipartConfig
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String studentName = "";
		int age = 0;
		String course = "";
		String action = "";
		String fileName = "";
		int id = 0;

		if (request.getParameter("studentName") != null) {
			studentName = request.getParameter("studentName").trim();
		}
		if (request.getParameter("age") != null) {
			age = Integer.parseInt(request.getParameter("age").toString().trim());
		}
		if (request.getParameter("course") != null) {
			course = request.getParameter("course").trim();
		}
		if (request.getParameter("action") != null) {
			action = request.getParameter("action").trim();
		}

		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id").toString().trim());
		}

		Student student = new Student();
		StudentService studentService = new StudentService();

		if (action.equals("add")) {
			try {

				Part part = request.getPart("file");
				// If the part is a file, process it
				if (!part.getSubmittedFileName().isEmpty()) {
					// Get the file name
					fileName = new File(part.getSubmittedFileName()).getName();
					String filePath = Constants.path + File.separator + fileName;
					File storeFile = new File(filePath);
					System.out.println("File name and path : " + filePath);
					// Save the file to the specified directory
					part.write(storeFile.toString());

				}
			} catch (Exception e) {
				request.setAttribute("message", "File Upload Failed due to " + e);
			}
			System.out.println("Debug Insert :: " + studentName + " " + age + " " + course);
			student.setName(studentName);
			student.setAge(age);
			student.setCourse(course);
			student.setProfileImage(fileName);
			boolean dataInserted = studentService.addUserDetails(student);
			if (dataInserted) {
				response.sendRedirect("profile.jsp");
			} else {
				response.sendRedirect("profile.jsp");
			}
		}

		if (action.equals("delete")) {

			if (studentService.deleteUserByUserId(id)) {
				response.sendRedirect("profile.jsp");
			} else {
				response.sendRedirect("profile.jsp");
			}

		}

		if (action.equals("update")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("updateUserDetail.jsp");
			request.setAttribute("id", id);
			dispatcher.forward(request, response);
		}

		if (action.equals("updateData")) {
			student.setId(id);
			student.setName(studentName);
			student.setCourse(course);
			student.setAge(age);
			studentService.updateUserByUserId(student);
			response.sendRedirect("profile.jsp");
		}
		
		
		if (action.equals("updateImage")) {
			System.out.print("update Image");
		}
		
		

	}

}
