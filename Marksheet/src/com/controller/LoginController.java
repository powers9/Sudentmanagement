package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.User;
import com.service.UserAuthentication;

public class LoginController extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		try {
			if (op.equalsIgnoreCase("submit")) {
				HttpSession s = request.getSession(true);
				User user = new User();
				user.setUser(request.getParameter("user"));
				user.setPass(request.getParameter("password"));
				int m = UserAuthentication.Authenticate(user);
				if (m > 0) {
					s.setAttribute("username", user.getUser());
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/Marksheet.jsp");
					dispatcher.forward(request, response);

				} else {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/Login.jsp");
					dispatcher.forward(request, response);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		
}
