package com.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.Student;
import com.dto.StudentBean;
import com.service.Service;

public class MarksheetCtrl extends HttpServlet {

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
		String s = request.getServletPath();
		System.out.println(s);
		  
		@SuppressWarnings("rawtypes")
		Enumeration paramaterNames = request.getParameterNames();
		while(paramaterNames.hasMoreElements() ) {
		       System.out.println(paramaterNames.nextElement());
		} 

	    String fisrname=request.getParameter("patrika"); //this is the varaiblr which is returnign null value
		int rollno = Integer.parseInt(request.getParameter("rollno"));
		int marks = Integer.parseInt(request.getParameter("marks"));
		int physics = Integer.parseInt(request.getParameter("phy"));
		int chemistry = Integer.parseInt(request.getParameter("chem"));
		int math = Integer.parseInt(request.getParameter("math"));
		String op = request.getParameter("operation");
		Student student = new Student();
		System.out.println("entered the servlet");
System.out.println(fisrname);

		
			try {
				if ("add".equalsIgnoreCase(op))
				student.setFname(fisrname);
				System.out.println("Add name@@@---"+student.getFname());
				student.setMarks(marks);
				student.setRollno(rollno);
				student.setPhy(physics);
				student.setChem(chemistry);
				student.setMath(math);
				System.out.println("executing servlet");
				int i;
				String m;
				i = Service.add(student);
				System.out.println("user added");
				if (i > 0) {
					m = "Marksheet data added successfully";
					RequestDispatcher rd = request
							.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
					request.setAttribute("marksheet entered", m);
				}

				else {
					m = "Marksheet data submission failed";
					request.setAttribute("marksheet entered", m);
				}

			} catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
	}
}
