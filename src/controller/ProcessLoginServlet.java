package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.sql.SQLOperations;
import model.MemberBean;

import java.sql.*;

@WebServlet("/processlogin.html")
public class ProcessLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	
	public void init() throws ServletException {
		connection = SQLOperations.getConnection();
		
		if (connection != null) {
			getServletContext().setAttribute("dbConnection", connection);
			System.out.println("connection is READY.");
		} else {
			System.err.println("connection is NULL.");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		try {
			if (connection != null) {
				MemberBean member = SQLOperations.retrieveMember(username,
						connection);
				if (member.getUsername().equals(username)
						&& member.getPassword().equals(password)) {
					System.out.println("successful login");
					request.setAttribute("member", member);
					getServletContext().getRequestDispatcher(
							"/actionstatus.jsp?success=login").forward(request,
							response);
				} else {
					System.out.println("invalid password");
					getServletContext().getRequestDispatcher(
							"/actionstatus.jsp?success=invalidPassword").forward(
							request, response);
				}
			} else {
				System.out.println("invalid connection");
			}
		} catch (Exception e) {
			System.out.println("username does not exist");
			getServletContext().getRequestDispatcher(
					"/actionstatus.jsp?success=doesNotExist").forward(
					request, response);
		}
	}

}
