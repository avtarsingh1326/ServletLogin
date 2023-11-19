package com.login.serlvet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String username = request.getParameter("username").toString().trim();
 		String password = request.getParameter("password");
		
 		HttpSession session = request.getSession();
 		
 		PrintWriter out =  response.getWriter();
 		LoginService loginService = new LoginService();
 	
 		
 		if(loginService.login(username, password)) {
 			session.setAttribute("username", username);
 			RequestDispatcher dispatcher = request.getRequestDispatcher("MyProfileServlet");
 			System.out.println("*******");
			dispatcher.forward(request, response);
 		}else {
 			response.sendRedirect("logout.jsp?message=Username or password is incorrect");
 		}
 		out.close();
 		
	}

}
