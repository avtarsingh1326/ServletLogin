package com.login.serlvet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyProfileServlet
 */
@WebServlet("/MyProfileServlet")
public class MyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		
		String sortType = "";
		if(request.getParameter("sortType") != null) {
			sortType = request.getParameter("sortType").toString();
		}
		
		if(session != null && session.getAttribute("username")!= null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("myprofile.jsp");
			request.setAttribute("sortType", sortType);
			request.setAttribute("username", session.getAttribute("username"));
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
