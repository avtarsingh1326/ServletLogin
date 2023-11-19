package com.login.serlvet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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

		Part part = request.getPart("file");
		String uploadPath = "/Users/avtarbadwal/eclipse-workspace/LoginExample2/src/main/webapp";

		File file = new File(uploadPath+"/"+ id);

		try (InputStream input = part.getInputStream();

				OutputStream output = new FileOutputStream(file)) {
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			while ((bytesRead = input.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
				System.out.println(buffer);
			}
		}
		

		Student student = new Student();
		StudentService studentService = new StudentService();

		if (action.equals("add")) {
			System.out.println("Debug Insert :: " + studentName + " " + age + " " + course);
			student.setName(studentName);
			student.setAge(age);
			student.setCourse(course);
			boolean dataInserted = studentService.addUserDetails(student);
			if (dataInserted) {
				response.sendRedirect("myprofile.jsp");
			} else {
				response.sendRedirect("myprofile.jsp");
			}
		}

		if (action.equals("delete")) {

			if (studentService.deleteUserByUserId(id)) {
				response.sendRedirect("myprofile.jsp");
			} else {
				response.sendRedirect("myprofile.jsp");
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

			response.sendRedirect("myprofile.jsp");

		}

	}

}
